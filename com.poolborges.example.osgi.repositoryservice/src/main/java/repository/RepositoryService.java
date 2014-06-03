package repository;


public interface RepositoryService {

    public Node put(String path, Node content);

    public Node get(String path);
}