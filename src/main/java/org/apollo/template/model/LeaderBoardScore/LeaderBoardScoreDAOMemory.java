package org.apollo.template.model.LeaderBoardScore;

import org.apollo.template.persistence.DAO;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardScoreDAOMemory implements DAO<LeaderBoardScore> {

    List<LeaderBoardScore> leaderBoardScoreList;

    public LeaderBoardScoreDAOMemory() {
        this.leaderBoardScoreList = new ArrayList<LeaderBoardScore>();
    }

    @Override
    public void add(LeaderBoardScore leaderBoardScore) {
        leaderBoardScoreList.add(leaderBoardScore);
    }

    @Override
    public void addAll(List<LeaderBoardScore> list) {
        leaderBoardScoreList.addAll(leaderBoardScoreList);
    }

    @Override
    public void delete(LeaderBoardScore leaderBoardScore) {
        leaderBoardScoreList.remove(leaderBoardScore);
    }

    @Override
    public void deleteAll(List<LeaderBoardScore> list) {
        leaderBoardScoreList.removeAll(list);
    }

    @Override
    public void update(LeaderBoardScore leaderBoardScore) {

    }

    @Override
    public void updateAll(List<LeaderBoardScore> t) {

    }

    @Override
    public LeaderBoardScore read(int id) {
        return leaderBoardScoreList.get(id);
    }

    @Override
    public List<LeaderBoardScore> readAll() {
        return leaderBoardScoreList;
    }
}
