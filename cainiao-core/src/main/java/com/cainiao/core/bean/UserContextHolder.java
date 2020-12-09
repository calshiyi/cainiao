package com.cainiao.core.bean;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * 用户上下文
 */
public class UserContextHolder {

    private InheritableThreadLocal<Map<String, Object>> threadLocal;

    private UserContextHolder() {
        this.threadLocal = new InheritableThreadLocal<>();
    }

    /**
     * 创建实例
     *
     * @return
     */
    public static UserContextHolder getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类单例模式
     * 单例初使化
     */
    private static class SingletonHolder {
        private static final UserContextHolder sInstance = new UserContextHolder();
    }

    /**
     * 用户上下文中放入信息
     *
     * @param map
     */
    public void setContext(Map<String, Object> map) {
        threadLocal.set(map);
    }

    /**
     * 获取上下文中的信息
     *
     * @return
     */
    public Map<String, Object> getContext() {
        return threadLocal.get();
    }

    /**
     * 获取上下文中的用户名
     *
     * @return
     */
    @Deprecated
    public String getUsername() {
        return (String) Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("userName");
    }

    /**
     * 获取userId
     *
     * @return
     */
    public String getUserId() {
        return (String) Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("userId");
    }
    /**
     * 获取roleId
     *
     * @return
     */
    public Integer getRoleId() {
        return (Integer) Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("roleId");
    }

    /**
     * 获取开启数据权限标识
     *
     * @return
     */
    public boolean getPermission() {
        return (boolean) Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("permission");
    }


    /**
     * 获取groupId
     *
     * @return
     */
    @Deprecated
    public String getGroupId() {
        return (String) Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("groupId");
    }

    /**
     * 清空上下文
     */
    public void clear() {
        threadLocal.remove();
    }

}
