# ProductSaleNotifierJava
Product sale notification message processor
#
The ProductSaleNotifier program implements an application that can accept
sales notification, process, record and report total sale after every tenth
notification. This program will stop accepting new notification after fifty
notifications.
#
# This program accept sale notification message as a string in three formats.
#  
  Format 1 : $MSG_TYPE $PRODUCT $PRICE 
  
  Format 2 : $MSG_TYPE $PRODUCT $PRICE $QUANTITY 
  
  Format 3 : $MSG_TYPE $PRODUCT $ADJUSTMENT_TYPE $ADJUSTMENT_FACTOR
# 
#
  Where $MSG_TYPE can be TYPE1, TYPE2, TYPE3
  
  and $PRODUCT can be APPLE, APRICOT, BANANA, GUAVA, KIWI, MANGO,	ORANGE,	PAPAYA, PEACH, PINEAPPLE
  
  and $PRICE can be any integer value as price in pense per product
  
  and $QUANTITY can be be any integer value as quantity of products in that sale
  
  and $ADJUSTMENT_TYPE can be ADD, SUBTRACT, MULTIPLY to specify type adjustment in sale
  
  and $ADJUSTMENT_FACTOR can be any integer value as to specify factor of adjustment in sale
#
