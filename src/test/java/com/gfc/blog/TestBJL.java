package com.gfc.blog;

import java.util.ArrayList;
import java.util.List;

/**
 * BJL 测试
 */
public class TestBJL {
    /*4-8   52*/
    public static void main(String[] args) {
        List<PaiDui> paiDuiList = new ArrayList<>();
        int paiNum = 4;
        System.out.println("有"+paiNum+"副牌");
        for (int i = 0; i < paiNum; i++) {
            paiDuiList.add(new PaiDui());
        }
        for (int i = 0; i < paiDuiList.size(); i++) {
            int temp = i+1;
            System.out.println("第"+temp+"副牌：");
            System.out.println("heitao："+paiDuiList.get(i).getSpadePai().toString());
            System.out.println("hongtao："+paiDuiList.get(i).getHeartPai().toString());
            System.out.println("meihua："+paiDuiList.get(i).getClubPai().toString());
            System.out.println("fangkuai："+paiDuiList.get(i).getDiamondPai().toString());
        }

        System.out.println("洗牌：");
        List<Integer> xiPai = new ArrayList<>();
        for (int i = 0; i < paiDuiList.size(); i++) {
            int temp = i+1;
            System.out.println("第"+temp+"副牌：");
            for (Integer pai:paiDuiList.get(i).getSpadePai()) {
                xiPai.add(pai);
            }
            for (Integer pai:paiDuiList.get(i).getHeartPai()) {
                xiPai.add(pai);
            }
            for (Integer pai:paiDuiList.get(i).getClubPai()) {
                xiPai.add(pai);
            }
            for (Integer pai:paiDuiList.get(i).getDiamondPai()) {
                xiPai.add(pai);
            }
        }




    }

}
