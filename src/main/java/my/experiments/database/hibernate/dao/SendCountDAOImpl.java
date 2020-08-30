package my.experiments.database.hibernate.dao;

import my.experiments.database.entity.SendCount;
import my.experiments.database.hibernate.util.HibernateSessionFactorUtil;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class SendCountDAOImpl {

    public List<SendCount> listAllSendCounts() {
        Session session = HibernateSessionFactorUtil.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<SendCount> sendCounts = session.createQuery("FROM my.experiments.database.entity.SendCount").list();
        session.close();
        System.out.println("Found " + sendCounts.size() + " SendCounts");
        return sendCounts;
    }

    public List<SendCount> listAllSendCountsUsingNamedQuery() {
        Session session = HibernateSessionFactorUtil.getSessionFactory().openSession();
        Map<String, Object> params = new HashMap<>();
        params.put("listId", 10092);
        params.put("channelId", 3);
        params.put("status", 1);
        params.put("channelQualifiers", "apvwlgcdpW,gc43ck7h8R");

        Query query = session.getNamedQuery("SendCount.findLatestTimeZoneSendCountForMobilePush");

        // Bind the requested parameters
        for (Iterator i = params.entrySet().iterator(); i.hasNext();) {
            Map.Entry entry = (Map.Entry) i.next();
            if (entry.getValue() instanceof Collection) {
                query.setParameterList((String) entry.getKey(), (Collection) entry.getValue());
            } else {
                query.setParameter((String) entry.getKey(), entry.getValue());
            }
        }
        List<SendCount> sendCounts = query.list();

        System.out.println("Found " + sendCounts.size() + " SendCounts using Named Query");
        return sendCounts;
    }

    public List<SendCount> listAllSendCountsUsingNamedNativeQuery() {
        Session session = HibernateSessionFactorUtil.getSessionFactory().openSession();

        Query query = session.getNamedQuery("SendCount.findLatestTimeZoneSendCountForMobilePushUsingNamedNativeQuery");
        query.setParameter("listId", 10092);
        query.setParameter("channelId", 3);
        query.setParameter("status", 1);
        query.setParameter("channelQualifiers", "apvwlgcdpW,gc43ck7h8R");

        List<SendCount> sendCounts = query.list();

        if (!sendCounts.isEmpty()) {
            System.out.println("#### FIRST VALUE [START]");
            System.out.println(sendCounts.get(0).toString());
            System.out.println("#### FIRST VALUE [END]");
        }

        System.out.println("Found " + sendCounts.size() + " SendCounts using Named Native Query");
        return sendCounts;
    }

    public List<SendCount> listAllSendCountsUsingCriteria() {
        Session session = HibernateSessionFactorUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(SendCount.class);
        criteria.add(Restrictions.in("listId ", new Long[]{10092L}));

        List<SendCount> sendCounts = criteria.list();
        System.out.println("Found " + sendCounts.size() + " SendCounts using Criteria");
        return sendCounts;

    }

}


