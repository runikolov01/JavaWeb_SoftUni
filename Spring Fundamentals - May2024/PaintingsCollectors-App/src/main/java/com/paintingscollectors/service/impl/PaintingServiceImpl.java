package com.paintingscollectors.service.impl;

import com.paintingscollectors.config.UserSession;
import com.paintingscollectors.model.dto.AddPaintingDTO;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.PaintingRepository;
import com.paintingscollectors.repository.StyleRepository;
import com.paintingscollectors.repository.UserRepository;
import com.paintingscollectors.service.PaintingService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PaintingServiceImpl implements PaintingService {
    private final PaintingRepository paintingRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;
    private final StyleRepository styleRepository;

    public PaintingServiceImpl(PaintingRepository paintingRepository, UserRepository userRepository, UserSession userSession, StyleRepository styleRepository) {
        this.paintingRepository = paintingRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.styleRepository = styleRepository;
    }

    @Transactional
    @Override
    public List<Painting> findAllPaintingsForOneUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getPaintings();
    }

    @Override
    public boolean create(AddPaintingDTO data) {
        if (!userSession.isLoggedIn()) {
            return false;
        }

        Optional<User> byId = userRepository.findById(userSession.id());

        if (byId.isEmpty()) {
            return false;
        }

        Optional<Style> byStyle = styleRepository.findByStyle(data.getStyle());

        if (byStyle.isEmpty()) {
            return false;
        }

        Painting painting = new Painting();
        painting.setName(data.getName());
        painting.setAuthor(data.getAuthor());
        painting.setStyle(byStyle.get());
        painting.setOwner(byId.get());
        painting.setImageUrl(data.getImage());

        paintingRepository.save(painting);

        return true;
    }

    @Override
    public boolean removeById(Long id) {
        Painting painting = paintingRepository.findById(id).orElse(null);
        if (painting == null) {
            return false;
        }

        paintingRepository.delete(painting);

        return true;
    }

    @Override
    public List<Painting> findAllPaintingsExceptUser(Long userId) {
        User loggedInUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<Painting> allPaintingsExceptUser = paintingRepository.findAllByOwnerNot(loggedInUser);

        return allPaintingsExceptUser;
    }

    @Transactional
    public void addFavorite(Long paintingId, Long userId) {
        Optional<Painting> paintingOpt = paintingRepository.findById(paintingId);
        Optional<User> userOpt = paintingRepository.findByIdWithFavouritePaintings(userId);

        if (paintingOpt.isPresent() && userOpt.isPresent()) {
            Painting painting = paintingOpt.get();
            User user = userOpt.get();

            user.getFavouritePaintings().add(painting);
            userRepository.save(user);
        }
    }

    @Transactional
    public void voteForPainting(Long paintingId, Long userId) {
        Optional<Painting> paintingOpt = paintingRepository.findById(paintingId);
        Optional<User> userOpt = paintingRepository.findByIdWithFavouritePaintings(userId);

        if (paintingOpt.isPresent() && userOpt.isPresent()) {
            Painting painting = paintingOpt.get();
            User user = userOpt.get();

            user.getRatedPainting().add(painting);
            painting.setVotes(painting.getVotes() + 1);
            userRepository.save(user);
        }
    }

    @Transactional
    @Override
    public List<Painting> findMostRatedPaintings() {
        return paintingRepository.findTop2ByOrderByVotesDesc();
    }

    @Transactional
    @Override
    public Set<Painting> findUserFavoritePaintings(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getFavouritePaintings();
    }

    @Override
    public void removeFavorite(Long paintingId, Long userId) {
        Painting painting = paintingRepository.findById(paintingId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid painting id: " + paintingId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + userId));

        user.getFavouritePaintings().remove(painting);
        userRepository.save(user);
    }
}