package main.service;

import jakarta.validation.Valid;
import main.exception.CustomException;
import main.model.House;
import main.model.Spell;
import main.model.Wizard;
import main.model.WizardAlignment;
import main.property.SpellsProperties;
import main.repository.WizardRepository;
import main.web.dto.EditProfileRequest;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class WizardService {

    private final WizardRepository wizardRepository;
    private final SpellService spellService;
    private final PasswordEncoder passwordEncoder;

    public WizardService(WizardRepository wizardRepository, SpellService spellService, PasswordEncoder passwordEncoder) {
        this.wizardRepository = wizardRepository;
        this.spellService = spellService;
        this.passwordEncoder = passwordEncoder;
    }


    public Wizard register(RegisterRequest registerRequest) {

        Wizard wizard = Wizard.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .avatarUrl(registerRequest.getAvatarUrl())
                .alignment(registerRequest.getAlignment())
                .house(registerRequest.getHouse())
                .spells(new ArrayList<>())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        wizardRepository.save(wizard);

        Spell randomSpell = spellService.createRandomSpellForRegistration(wizard);
        wizard.getSpells().add(randomSpell);

        return wizardRepository.save(wizard);
    }

    public Wizard login(LoginRequest loginRequest) {

        Optional<Wizard> wizard = wizardRepository.findByUsername(loginRequest.getUsername());
        if (wizard.isEmpty() || !passwordEncoder.matches(loginRequest.getPassword(), wizard.get().getPassword())) {
            throw new CustomException("Invalid username or password");
        }

        return wizard.get();
    }

    public Wizard getById(UUID userId) {

        return wizardRepository.getById(userId);
    }


    public Wizard learnSpell(Wizard wizard, String spellCode) {

        Spell spell = spellService.saveSpell(wizard, spellCode);

        if (wizard.getAlignment().getDisplayName().equals("Light") && spell.getAlignment().getDisplayName().equals("Dark")) {
            wizard.setAlignment(WizardAlignment.DARK);
        }

        return wizardRepository.save(wizard);
    }

    public Wizard update(Wizard wizard, EditProfileRequest editProfileRequest) {

        wizard.setUsername(editProfileRequest.getUsername());
        wizard.setAvatarUrl(editProfileRequest.getAvatarUrl());
        wizard.setUpdatedOn(LocalDateTime.now());

        return wizardRepository.save(wizard);
    }

    public Wizard updateAlignment(Wizard wizard) {

        wizard.setAlignment(WizardAlignment.DARK);
        wizard.setUpdatedOn(LocalDateTime.now());

        return wizardRepository.save(wizard);
    }

    public List<Wizard> getByHouse(House house) {

        List<Wizard> wizards = wizardRepository.findByHouse(house);
        List<Wizard> sortedWizards = wizards.stream()
                .sorted(
                        Comparator.comparingInt((Wizard w) ->
                                        w.getSpells().stream()
                                                .mapToInt(Spell::getPower)
                                                .sum()
                                ).reversed()
                                .thenComparing(Wizard::getUsername)
                )
                .toList();

        return sortedWizards;
    }
}
