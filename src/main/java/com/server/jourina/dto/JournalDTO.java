package com.server.jourina.dto;

import com.server.jourina.entity.Journal;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class JournalDTO {
    private Integer id;
    private String name;

    @Transactional
    public List<JournalDTO> getJournalDTOList(List<Journal> journalList){
        List<JournalDTO> journalDTOList = new ArrayList<>();
        for(Journal journal : journalList){
            JournalDTO journalDTO = new JournalDTO();
            journalDTO.setName(journal.getName());
            journalDTOList.add(journalDTO);
        }
        return journalDTOList;
    }

    @Transactional
    public List<JournalDTO> getJournalLoginDTOList(List<Journal> journalList){
        List<JournalDTO> journalLoginDTOList = new ArrayList<>();
        for(Journal journal : journalList){
            JournalDTO journalDTO = new JournalDTO();
            journalDTO.setId(journal.getId());
            journalDTO.setName(journal.getName());
            journalLoginDTOList.add(journalDTO);
        }
        return journalLoginDTOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
