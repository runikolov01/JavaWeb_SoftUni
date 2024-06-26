package com.paintingscollectors.repository;

import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {
    List<Painting> findAllByOwnerNot(User owner);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.favouritePaintings WHERE u.id = :id")
    Optional<User> findByIdWithFavouritePaintings(@Param("id") Long id);

    List<Painting> findTop2ByOrderByVotesDesc();

}
