package com.sbilogan.werewolfmoderator.model.roles;

/**
 * Created by Steve on 6/5/2016.
 */
public class RoleFactory {
    public Role createRole(String roleName) {
        switch (roleName) {
            case "Villager":
                return new Villager();
            case "Witch":
                return new Witch();
            case "Cupid":
                return new Cupid();
            case "Accursed Wolf Father":
                return new AccursedWolfFather();
            case "Big Bad Wolf":
                return new BigBadWolf();
            case "Elder":
                return new Elder();
            case "Hunter":
                return new Hunter();
            case "Seer":
                return new Seer();
            case "Knight":
                return new Knight();
            case "Thief":
                return new Thief();
            case "Werewolf":
                return new Werewolf();
            case "Wolf Hound":
                return new WolfHound();
            default:
                return new Villager();
        }
    }
}
