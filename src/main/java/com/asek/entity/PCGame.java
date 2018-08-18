package com.asek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAMES")
public class PCGame {

    @Id     //specifying PK
    @Column(name = "game_id")     //Setting the column name in db
    private long game_id;

    @Column(name = "game_title")
    private String title;

    @Column(name = "game_platform")
    private String platform;

    public long getId() {
        return game_id;
    }

    public void setId(long game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
