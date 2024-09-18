package com.games.prick.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearcResult {
    String serverId;
    String characterId;
    String characterName;
    String level;
    String jobId;
    String jobGrowId;
    String jobName;
    String jobGrowName;
    String fame;
}
