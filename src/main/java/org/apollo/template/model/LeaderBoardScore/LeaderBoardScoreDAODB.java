package org.apollo.template.model.LeaderBoardScore;

import org.apollo.template.Service.DatabaseHandler;
import org.apollo.template.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoardScoreDAODB implements DAO<LeaderBoardScore> {

    private Connection conn;

    public LeaderBoardScoreDAODB() {
        conn = DatabaseHandler.loadDB();
    }

    @Override
    public void add(LeaderBoardScore leaderBoardScore) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO MEDUSA_SCORE_TABLE (name, score) VALUES (?, ?)");
            ps.setString(1, leaderBoardScore.getName());
            ps.setInt(2, leaderBoardScore.getScore());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add LeaderBoardScore", e);
        }
    }

    @Override
    public void addAll(List<LeaderBoardScore> list) {
        for (LeaderBoardScore leaderBoardScore : list) {
            add(leaderBoardScore);
        }
    }

    @Override
    public void delete(LeaderBoardScore leaderBoardScore) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM MEDUSA_SCORE_TABLE WHERE name = ?");
            ps.setString(1, leaderBoardScore.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete LeaderBoardScore", e);
        }
    }

    @Override
    public void deleteAll(List<LeaderBoardScore> list) {
        for (LeaderBoardScore leaderBoardScore : list) {
            delete(leaderBoardScore);
        }
    }

    @Override
    public void update(LeaderBoardScore leaderBoardScore) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE MEDUSA_SCORE_TABLE SET score = ? WHERE name = ?");
            ps.setInt(1, leaderBoardScore.getScore());
            ps.setString(2, leaderBoardScore.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update LeaderBoardScore", e);
        }
    }

    @Override
    public void updateAll(List<LeaderBoardScore> list) {
        for (LeaderBoardScore leaderBoardScore : list) {
            update(leaderBoardScore);
        }
    }

    @Override
    public LeaderBoardScore read(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM MEDUSA_SCORE_TABLE WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new LeaderBoardScore(rs.getString("name"), rs.getInt("score"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to read LeaderBoardScore", e);
        }
        return null;
    }

    @Override
    public List<LeaderBoardScore> readAll() {
        List<LeaderBoardScore> scores = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM MEDUSA_SCORE_TABLE");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                scores.add(new LeaderBoardScore(rs.getString("name"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to read all LeaderBoardScores", e);
        }
        return scores;
    }
}
