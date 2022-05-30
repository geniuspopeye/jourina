package com.server.jourina.service;

import com.server.jourina.entity.Journal;
import com.server.jourina.repository.JournalRepository;
import com.server.jourina.repository.UserJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalService {
    @Autowired
    private final JournalRepository journalRepository;

    @Autowired
    private final UserJournalRepository userJournalRepository;

    public JournalService(JournalRepository journalRepository, UserJournalRepository userJournalRepository) {
        this.journalRepository = journalRepository;
        this.userJournalRepository = userJournalRepository;
    }

    public void createJournal(String name){
        Journal journal = new Journal();
        journal.setName(name);
        journalRepository.save(journal);
    }

    public Journal findById(Integer id){
        return journalRepository.findById(id).get();
    }
    public Journal getLastJournal(){
        return journalRepository.findFirstByOrderByIdDesc();
    }

    public void deleteJournal(Integer id){
        userJournalRepository.deleteJournal(id);
        journalRepository.delete(journalRepository.findById(id).get());
    }
}
