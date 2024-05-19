package com.example.datntest.service;

import com.example.datntest.entity.ChatLieu;
import com.example.datntest.entity.Size;
import org.springframework.data.domain.Page;


public interface ChatLieuService {
    Page<ChatLieu> getAll(int page);
    void add(ChatLieu chatLieu);
    ChatLieu detail(Integer id);
    ChatLieu delete(Integer id);
}
