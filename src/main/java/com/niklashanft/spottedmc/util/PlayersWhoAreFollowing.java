package com.niklashanft.spottedmc.util;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public enum PlayersWhoAreFollowing {
    INSTANCE;

    private final ConcurrentHashMap<UUID, Thread> followingPlayers = new ConcurrentHashMap<>();

    public void stopFollowing(UUID playerId) {
        if( !this.followingPlayers.containsKey(playerId)) { return; }
        Thread follower = this.followingPlayers.get(playerId);
        follower.interrupt();
    }

    public void addFollower(UUID followingPlayerId, Thread thread) {
        this.followingPlayers.putIfAbsent(followingPlayerId, thread);
    }


}
