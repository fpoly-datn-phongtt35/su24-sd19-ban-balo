package com.example.datntest.service.impl;

import com.example.datntest.entity.ChatLieu;
import com.example.datntest.repository.ChatLieuRepository;
import com.example.datntest.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChatLieuImpl implements ChatLieuService {
    @Autowired
    private ChatLieuRepository chatLieuRepository;
    @Override
    public Page<ChatLieu> getAll(int page) {
        Pageable pageable = PageRequest.of(page,3);
        return chatLieuRepository.findAll(pageable);
    }

    @Override
    public void add(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu detail(Integer idChatLieu) {
        return chatLieuRepository.findById(idChatLieu).orElse(null);
    }

    @Override
    public ChatLieu delete(Integer idChatLieu) {
        chatLieuRepository.deleteById(idChatLieu);
        return null;
    }

}
