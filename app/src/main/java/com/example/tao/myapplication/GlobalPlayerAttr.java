package com.example.tao.myapplication;

/**
 * Created by taoLen on 9/29/2018.
 */

public interface GlobalPlayerAttr {
    interface Warrior {
         int HP = 100;
         long GOLD = 1000;
         int ATTACK = 10;
    }
    interface Thief {
         int HP = 80;
         long GOLD = 1200;
         int Charisma = 10;
    }
    interface Mage {
         int HP = 120;
         long GOLD = 800;
         int SpellDamage = 10;
    }
    class BirthSign {
        static boolean Serpent=false;
        static boolean Lover=false;
        static boolean Lady=false;
    }
}
