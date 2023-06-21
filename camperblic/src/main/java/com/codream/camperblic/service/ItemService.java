package com.codream.camperblic.service;

import com.codream.camperblic.domain.item.*;
import com.codream.camperblic.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }



    public List<Cook> findCooks() {
        return itemRepository.findAllCook();
    }

    public List<Etc> findEtc() {
        return itemRepository.findAllEtc();
    }

    public List<Mat> findMat() {
        return itemRepository.findAllMat();
    }

    public List<Chair> findChair() {
        return itemRepository.findAllChair();
    }

    public List<Tent> findTent() {
        return itemRepository.findAllTent();
    }

    public Cook findCookDetail(String itemId) {return itemRepository.findCookById(itemId);}

    public Chair findChairDetail(String itemId) {return itemRepository.findChairById(itemId);}

    public Mat findMatDetail(String itemId) {return itemRepository.findMatById(itemId);}

    public Tent findTentDetail(String itemId) {return itemRepository.findTentById(itemId);}

    public Etc findEtcDetail(String itemId) {return itemRepository.findEtcById(itemId);}


    }

