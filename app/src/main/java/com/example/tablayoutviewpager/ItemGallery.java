package com.example.tablayoutviewpager;

public class ItemGallery {

    int img;
    String cardNum;
    String accept = "Accept";
    String cancel = "Cancel";

    public ItemGallery(int img, String cardNum, String accept, String cancel) {
        this.img = img;
        this.cardNum = cardNum;
        this.accept = accept;
        this.cancel = cancel;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }
}
