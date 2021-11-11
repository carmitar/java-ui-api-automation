package com.trello.api.rest.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Prefs {

    private String permissionLevel;
    private boolean hideVotes;
    private String voting;
    private String comments;
    private String invitations;
    private boolean selfJoin;
    private boolean cardCovers;
    private boolean isTemplate;
    private String cardAging;
    private boolean calendarFeedEnabled;
    private boolean isPluginHeaderShortcutsEnabled;
    private String background;
    private String backgroundImage;
    private String backgroundImageScaled;
    private String backgroundTile;
    private String backgroundBrightness;
    private String backgroundColor;
    private String backgroundBottomColor;
    private String backgroundTopColor;
    private boolean canBePublic;
    private boolean canBeEnterprise;
    private boolean canBeOrg;
    private boolean canBePrivate;
    private boolean canInvite;

    public void setIsTemplate(boolean template) {
        this.isTemplate = template;
    }
}
