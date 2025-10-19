package main.service;

import main.model.Spell;
import main.model.Wizard;
import main.property.SpellsProperties;
import main.repository.SpellRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


@Service
public class SpellService {

    private final SpellRepository spellRepository;
    private final SpellsProperties spellsProperties;

    public SpellService(SpellRepository spellRepository, SpellsProperties spellsProperties) {
        this.spellRepository = spellRepository;
        this.spellsProperties = spellsProperties;
    }

    public Spell createRandomSpellForRegistration(Wizard wizard) {

        List<SpellsProperties.Spell> availableSpells = spellsProperties.getSpellForRegistration();
        Random random = new Random();
        int randomSpellIndex = random.nextInt(0, availableSpells.size());
        SpellsProperties.Spell spell = availableSpells.get(randomSpellIndex);

        Spell spellToCreate = Spell.builder()
                .code(spell.getCode())
                .name(spell.getName())
                .description(spell.getDescription())
                .wizard(wizard)
                .category(spell.getCategory())
                .alignment(spell.getAlignment())
                .image(spell.getImage())
                .power(spell.getPower())
                .createdOn(LocalDateTime.now())
                .build();

        return spellRepository.save(spellToCreate);
    }

    public List<SpellsProperties.Spell> getAllUnlearnedAndAvailableSpells(Wizard wizard) {

        List<SpellsProperties.Spell> availableSpells = spellsProperties.getSpells()
                .stream()
                .filter(spell ->
                        wizard.getSpells().stream()
                                .noneMatch(wizardSpell -> wizardSpell.getCode().equals(spell.getCode()))
                                &&
                                spell.getAlignment().getDisplayName().equals(wizard.getAlignment().getDisplayName())
                )
                .sorted(Comparator.comparingInt(SpellsProperties.Spell::getPower).reversed())
                .toList();

        return availableSpells;
    }

    public List<SpellsProperties.Spell> getAllUnlearnedAndUnavailableSpells(Wizard wizard) {
        List<SpellsProperties.Spell> availableSpells = spellsProperties.getSpells()
                .stream()
                .filter(spell ->
                        wizard.getSpells().stream()
                                .noneMatch(wizardSpell -> wizardSpell.getCode().equals(spell.getCode()))
                                &&
                                !spell.getAlignment().getDisplayName().equals(wizard.getAlignment().getDisplayName())
                )
                .sorted(Comparator.comparingInt(SpellsProperties.Spell::getPower).reversed())
                .toList();

        return availableSpells;
    }

    public List<SpellsProperties.Spell> getAllUnlearnedSpells(Wizard wizard) {

        return spellsProperties.getSpells()
                .stream()
                .filter(spell ->
                        wizard.getSpells().stream()
                                .noneMatch(wizardSpell -> wizardSpell.getCode().equals(spell.getCode()))
                )
                .sorted(Comparator.comparingInt(SpellsProperties.Spell::getPower).reversed())
                .toList();
    }

    public SpellsProperties.Spell getSpellProps(String spellCode) {
        return (SpellsProperties.Spell) spellsProperties.getSpells().stream().filter(spell -> spell.getCode().equals(spellCode));
    }

    public Spell saveSpell(Wizard wizard,String spellCode) {

        List<SpellsProperties.Spell> list = spellsProperties.getSpells().stream().filter(spell -> spell.getCode().equals(spellCode)).toList();
        SpellsProperties.Spell spellProps = list.get(0);

        Spell spell = Spell.builder()
                .code(spellProps.getCode())
                .name(spellProps.getName())
                .description(spellProps.getDescription())
                .wizard(wizard)
                .category(spellProps.getCategory())
                .alignment(spellProps.getAlignment())
                .image(spellProps.getImage())
                .power(spellProps.getPower())
                .createdOn(LocalDateTime.now())
                .build();

        return spellRepository.save(spell);
    }
}
