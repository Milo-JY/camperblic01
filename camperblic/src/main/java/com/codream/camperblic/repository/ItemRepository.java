package com.codream.camperblic.repository;

import com.codream.camperblic.domain.community.Campstory;
import com.codream.camperblic.domain.item.*;

import java.util.List;

public interface ItemRepository {


    List<Cook> findAllCook();

    List<Etc> findAllEtc();

    List<Mat> findAllMat();

    List<Chair> findAllChair();

    List<Tent> findAllTent();

    Cook findCookById(String itemId);

    Chair findChairById(String itemId);

    Mat findMatById(String itemId);

    Tent findTentById(String itemId);

    Etc findEtcById(String itemId);
}
