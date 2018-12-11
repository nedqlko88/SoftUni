package com.ned.gamestore.services.impl;

import com.ned.gamestore.models.Game;
import com.ned.gamestore.models.User;
import com.ned.gamestore.repositories.GameRepository;
import com.ned.gamestore.services.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;

@Service
@Transactional
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private Validator validator;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.getValidator();
    }

    @Override
    public void addGame(Game game) {
        if (this.checkIfGameExists(game.getTitle())) {
        this.gameRepository.findByTitle(game.getTitle());
            throw new IllegalArgumentException("Game already exists");
        }
        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(game);

        if (constraintViolations.size() == 0) {
        this.gameRepository.save(game);
        } else {
            for (ConstraintViolation<Game> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        }
    }

    @Override
    public boolean checkIfGameExists(String title) {
        Game game = this.gameRepository.findByTitle(title);
        return game != null;

    }

    @Override
    public Game findGameByTitle(String title) {
        return this.gameRepository.findByTitle(title);
    }

    public void getValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }


}
