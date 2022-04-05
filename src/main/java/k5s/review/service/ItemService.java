package k5s.review.service;

import k5s.review.domain.item.Item;
import k5s.review.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    @Transactional
    public void updateItem(Long id, String name, int price) { // public void updateItem(Long id, UpdateItemDto itemDto)
        Item item = itemRepository.findOne(id);
        //update로 따로함수만드는게 좋다
        //item.change(price, name, stockQuantity)
        item.setName(name);
        item.setPrice(price);
    }

}
