package my.experiments.database.hibernate;

import my.experiments.database.entity.SendCount;
import my.experiments.database.hibernate.dao.SendCountDAOImpl;

import java.util.List;

public class AppSendCount {

    public static void main(String[] args) {
        SendCountDAOImpl sendCountDAO = new SendCountDAOImpl();
//        List<SendCount> sendCounts = sendCountDAO.listAllSendCounts();
//        for(SendCount s: sendCounts) {
//            System.out.println("ID" + s.getId());
//        }

        List<SendCount> sendCounts = sendCountDAO.listAllSendCountsUsingCriteria();
        for(SendCount s: sendCounts) {
            System.out.println(s.toString());
        }
    }
}
