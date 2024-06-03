select distinct p.id, p.image, p.title, p.category_id
from product_specifications ps
join product p ON p.id = ps.product_id
where p.category_id = 1 and
      (
          (ps.specifications_id = 1 and ps.value = '3')
          or (ps.specifications_id = 1 and ps.value = '4')
          or (ps.specifications_id = 4 and ps.value = 'Apple')
      )
