package service;

/**
 * Service <<abstract>> - Service & Persistence Layer
 * คลาสแม่แบบกำหนดโครงเมธอดมาตรฐาน CRUD: save / load / delete
 * ตาม Class Diagram: fileService: FileStorageService
 */
public abstract class Service {

    protected FileStorageService fileService;

    public Service() {
        //  init fileService ถ้าจำเป็น
    }

    public abstract void save(Object data);

    public abstract Object load();

    public abstract void delete(String id);
}
