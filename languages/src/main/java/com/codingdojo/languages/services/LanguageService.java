package com.codingdojo.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository langRepo) {
		this.languageRepository = langRepo;
	}
	
	public List<Language> allLang(){
		return languageRepository.findAll();
	}
	
	public Language findLang(Long id) {
		return languageRepository.findById(id).orElse(null);
	}
	
	public Language createLang(Language language) {
		return languageRepository.save(language);
	}
	
	public Language updateLang(Language language) {
		return languageRepository.save(language);
	}
	
	public void deleteLang(Long id) {
		languageRepository.deleteById(id);
	}
}
