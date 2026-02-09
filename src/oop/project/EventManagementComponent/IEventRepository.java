package oop.project.EventManagementComponent;

import oop.project.generalInteface.IRepository;

import java.util.List;

public interface IEventRepository extends IRepository<Event> {
    List<Event> findByTitle(String title);
}
