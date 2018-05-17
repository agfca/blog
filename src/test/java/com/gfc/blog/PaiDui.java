package com.gfc.blog;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//pai dui
public class PaiDui {


    private Set<Integer> spadePai;//hei tao
    private Set<Integer> heartPai;//hong tao
    private Set<Integer> clubPai;//mei hua
    private Set<Integer> diamondPai;//fang kuai

    public PaiDui() {
        Set<Integer> temp = new HashSet<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);
        temp.add(7);
        temp.add(8);
        temp.add(9);
        temp.add(10);
        temp.add(11);
        temp.add(12);
        temp.add(13);
        this.spadePai = temp;
        this.heartPai = temp;
        this.clubPai = temp;
        this.diamondPai = temp;
    }

    public Set<Integer> getSpadePai() {
        return spadePai;
    }

    public void setSpadePai(Set<Integer> spadePai) {
        this.spadePai = spadePai;
    }

    public Set<Integer> getHeartPai() {
        return heartPai;
    }

    public void setHeartPai(Set<Integer> heartPai) {
        this.heartPai = heartPai;
    }

    public Set<Integer> getClubPai() {
        return clubPai;
    }

    public void setClubPai(Set<Integer> clubPai) {
        this.clubPai = clubPai;
    }

    public Set<Integer> getDiamondPai() {
        return diamondPai;
    }

    public void setDiamondPai(Set<Integer> diamondPai) {
        this.diamondPai = diamondPai;
    }
}
