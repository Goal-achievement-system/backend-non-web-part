package com.j2kb.goalkeeperautodelete.repository;

import com.j2kb.goalkeeperautodelete.dto.Notification;

public interface NotificationRepository {
    void sendNotification(Notification notification);
}
