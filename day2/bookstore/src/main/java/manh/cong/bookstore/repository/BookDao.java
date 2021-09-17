package manh.cong.bookstore.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import manh.cong.bookstore.model.Book;

public class BookDao extends Dao<Book> {

  public BookDao() {
    collections.add(new Book(1, "Không gia đình", "Chú bé Remy lang thang theo gánh xiếc của bác Vitaly"));
    collections.add(new Book(2, "Cuốn theo chiều gió", "Nội chiến Hoa kỳ, cuộc tình giữa Red Butler và Ohara"));
    collections.add(new Book(3, "Harry Potter", "Cuộc phiêu lưu phù thủy của Harry Potter cùng hai người bạn thân"));
  }

  @Override
  public List<Book> getAll() {
    return collections;
  }

  @Override
  public Optional<Book> get(int id) {
    return Optional
        .ofNullable(collections.stream().filter(book -> book.getId() == id).collect(Collectors.toList()).get(0));
  }

  @Override
  public void add(Book t) {
    collections.add(t);
  }

  @Override
  public void update(int id, Book t) {
    int index = -1;
    for (int i = 0; i < collections.size(); i++) {
      if (collections.get(i).getId() == id) {
        index = i;
        break;
      }
    }
    collections.set(index, t);
  }

  @Override
  public void deleteByID(int id) {
    collections.removeIf(book -> book.getId() == id);
  }

}