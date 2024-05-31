package com.example.datntest.service;

import com.example.datntest.entity.ChatLieu;
import org.springframework.data.domain.Page;


public interface ChatLieuService {
    Page<ChatLieu> getAll(int page);
    void add(ChatLieu chatLieu);
    ChatLieu detail(Integer idChatLieu);
    ChatLieu delete(Integer idChatLieu);
}
