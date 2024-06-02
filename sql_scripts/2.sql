select product_specifications.specifications_id, specifications.title, array_agg(product_specifications.value) values, array_agg(product_specifications.product_id) product_ids
from product_specifications
join product ON product.id = product_specifications.product_id
join specifications on product_specifications.specifications_id = specifications.id
where product.category_id = 1
group by product_specifications.specifications_id, specifications.title