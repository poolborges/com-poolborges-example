package com.poolborges.example.jpa21;

import com.poolborges.example.jpa21.model.Device;
import com.poolborges.example.jpa21.model.DeviceType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();


        Device devC = createDevice(1, "CoodFloor0", DeviceType.COORDINATOR);

        em.getTransaction().begin();
        em.persist(devC);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.persist(createDevice(2, "CoodFloor1", DeviceType.COORDINATOR));
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.persist(createDevice(3, "CoodFloor3", DeviceType.COORDINATOR));
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.persist(createDevice(4, "ZHA_TH", DeviceType.ROUTER));
        em.getTransaction().commit();

        TypedQuery<Device> query =
                em.createQuery("SELECT d from Device d", Device.class);
        List<Device> deviceList;
        deviceList = query.getResultList();

        for (Device f : deviceList) {
            System.out.println(f);
        }
    }

    private static Device createDevice(
            long id,
            String name,
            DeviceType type) {

        Device device = new Device();
        device.setId(id);
        device.setName(name);
        device.setDeviceType(type);

        return device;
    }
}
