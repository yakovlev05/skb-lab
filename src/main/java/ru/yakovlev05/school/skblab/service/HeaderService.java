package ru.yakovlev05.school.skblab.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@Service
public class HeaderService {

    public void getHeaders(MultiValueMap<String, String> headers, Model model) {
        Map<String, String> headersMap = new HashMap<>();

        for (String key : headers.keySet()) {
            headersMap.put(key, String.join(", ", headers.get(key)));
        }

        model.addAttribute("headers", headersMap);
    }

}
