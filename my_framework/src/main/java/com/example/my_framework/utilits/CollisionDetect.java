package com.example.my_framework.utilits;

import com.example.my_framework.ObjectsFW;

public class CollisionDetect {

    public static boolean collisionDetect(ObjectsFW object1, ObjectsFW object2) {

        double object1X = object1.getHitBox().centerX();
        double object1Y = object1.getHitBox().centerY();

        double object2X = object2.getHitBox().centerX();
        double object2Y = object2.getHitBox().centerY();

        double radiusObject1 = object1.getRadius();
        double radiusObject2 = object2.getRadius();

        double dx = object1X - object2X;
        double dy = object1Y - object2Y;

        double distanceObjects = Math.sqrt(dx * dx + dy * dy);

        return distanceObjects < (radiusObject1 + radiusObject2);
    }

}
