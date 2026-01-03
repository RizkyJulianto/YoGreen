/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import model.User;

/**
 *
 * @author HYPE AMD
 */
public class Sessions {
    public static User user;
    
    public static void logout() {
        user = null;
    }
}
