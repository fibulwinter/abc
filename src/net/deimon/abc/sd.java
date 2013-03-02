/*
package net.deimon.abc;

import java.nio.file.Path;

*/
/**
 * Created by IntelliJ IDEA.
 * User: deimon
 * Date: 4/9/12
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 *//*

public class sd {
    private static final Object MOVE_TARGET_BY_PLAYER = "";
    private static final Object FREE_HUNT = "";
    private static final Object FIRE_TARGET_BY_PLAYER = "";

    public static void main(String[] args) {
        Object mode=null;
        Object path=null;
        Object moveTarget = null;
        Object fireTarget=null;
        Object pos=null;
        if(mode==MOVE_TARGET_BY_PLAYER){
            if(!isMoving()){
                if(pos==moveTarget){
                    moveTarget=null;
                    mode=FREE_HUNT;
                    path=null;
                    return;
                }
                if(path==null || isBlocked(path)){
                    path=findPath();
                    if(path==null){
                        moveTarget=null;
                        mode=FREE_HUNT;
                        return;
                    }
                    send(path);
                }
            }
            if(fireTarget==null || !isInRange(fireTarget)){
                fireTarget=findTargetInRange();
                if(fireTarget!=null){
                    send(fireTarget);
                }
            }
        }
        if(mode==FIRE_TARGET_BY_PLAYER){
            if(!isInRange(fireTarget)){
                if(path=findPath();)

            }
            if(!isMoving()){
                if(pos==moveTarget){
                    moveTarget=null;
                    mode=FREE_HUNT;
                    path=null;
                    return;
                }
                if(path==null || isBlocked(path)){
                    path=findPath();
                    if(path==null){
                        moveTarget=null;
                        mode=FREE_HUNT;
                        return;
                    }
                    send(path);
                }
            }
            if(fireTarget==null || !isInRange(fireTarget)){
                fireTarget=findTargetInRange();
                if(fireTarget!=null){
                    send(fireTarget);
                }
            }
        }
    }

    private static boolean isInRange(Object fireTarget) {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private static Object findTargetInRange() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private static boolean isMoving() {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private static void send(Object path) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private static boolean isBlocked(Object path) {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private static Object findPath() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
*/
