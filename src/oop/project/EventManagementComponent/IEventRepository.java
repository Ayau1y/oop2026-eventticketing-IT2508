package oop.project.EventManagementComponent;

import java.util.List;

public interface IEventRepository extends oop.project.repositories.interfaces.IRepository<Event> {
    List<Event> findByTitle(String title);
}
