package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.AddPaintingDTO;
import com.paintingscollectors.model.entity.Painting;

import java.util.List;
import java.util.Set;

public interface PaintingService {
    List<Painting> findAllPaintingsForOneUser(Long id);

    boolean create(AddPaintingDTO data);

    boolean removeById(Long id);

    List<Painting> findAllPaintingsExceptUser(Long userId);

    void addFavorite(Long paintingId, Long userId);

    void voteForPainting(Long paintingId, Long userId);

    List<Painting> findMostRatedPaintings();

    Set<Painting> findUserFavoritePaintings(Long userId);

    void removeFavorite(Long paintingId, Long userId);
}