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
            default:
                return new Villager();
        }
    }
}
