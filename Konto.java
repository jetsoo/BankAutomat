package com.company;

public abstract class Konto {
    private Long id;
    private Boolean gesperrt = false;
    protected Integer money;
    private Owner owner;
    private Integer password;
    protected Integer minKontoStand = 0;
    protected Integer maxRemoval;
    private Typ typ;
    private Integer passwordVersuche;

    public Konto(Long id,  Integer money, Owner owner, Integer password, Integer minKontoStand, Integer maxRemoval, Typ typ) {
        this.id = id;
        this.money = money;
        this.owner = owner;
        this.password = password;
        this.maxRemoval = maxRemoval;
        this.minKontoStand = minKontoStand;
        this.typ = typ;
        this.passwordVersuche = 0;
    }

    public boolean canRemove(int removeOptional){
        if(this.minKontoStand <= this.money - removeOptional && removeOptional <= this.maxRemoval){
            return true;
        }
        return false;
    }

    public void removeMoney(int minusMoney) {
            this.money -= minusMoney;
    }


    public  void addMoney(int plusMoney){
        this.money += plusMoney;
    }

    public Integer getPasswordVersuche() {
        return passwordVersuche;
    }

    public void setPasswordVersuche(Integer passwordVersuche) {
        this.passwordVersuche = passwordVersuche;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public Integer getMinKontoStand() {
        return minKontoStand;
    }

    public void setMinKontoStand(Integer minKontoStand) {
        this.minKontoStand = minKontoStand;
    }

    public Integer getMaxRemoval() {
        return maxRemoval;
    }

    public void setMaxRemoval(Integer maxRemoval) {
        this.maxRemoval = maxRemoval;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getGesperrt() {
        return gesperrt;
    }

    public void setGesperrt(Boolean gesperrt) {
        this.gesperrt = gesperrt;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Konto{" +
                "id=" + id +
                ", gesperrt=" + gesperrt +
                ", money=" + money +
                ", owner=" + this.owner.toString()+
                ", minKontoStand=" + minKontoStand +
                ", typ=" + typ +
                '}';
    }
}
