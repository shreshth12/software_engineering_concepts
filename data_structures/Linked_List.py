class ListNode:
    """
    Class to create a node to form a linked list
    Initilize the class with two variables :-
    value: Value that the current node holds
    next: Address/Pointer to the next node
    """

    def __init__(self, value, next=None):
        self.value = value
        self.next = next


class LinkedList:
    """
    Class to use the "ListNode" class to implement a linked list
    Initilize the class with two variables :-
    head: pointing to the head of the linked list
    tail: pointing to the tail of the linked list
    """

    def __init__(self):
        self.head = ListNode(value=0, next=None)
        self.tail = self.head

    # Function to get the ith node
    def get(self, index: int) -> int:
        curr, curr_index = self.head.next, 0
        while curr != None:
            if curr_index == index:
                return curr.value
            curr = curr.next
            curr_index += 1
        # If an index was not found (Out of bounds), return -1
        return -1

    # Function to insert a node at the head
    def insert_head(self, value: int) -> None:
        new_node = ListNode(value=value)
        new_node.next = self.head.next
        self.head.next = new_node

        # It is possible that the current linked list was empty
        # in that case, our tail should be the node that was inserted
        if new_node.next == None:
            self.tail = new_node

    # Function to insert a node at the tail
    def insert_tail(self, value: int) -> None:
        new_node = ListNode(value=value)
        self.tail.next = new_node
        self.tail = self.tail.next

    # Function to remove a node at given index
    def remove(self, index: int) -> bool:
        curr, point_to = self.head, 0

        # Increment the curr index and the pointer until
        # the pointer is pointing to the node to remove
        while point_to < index:
            if curr == None:
                return False
            curr = curr.next
            point_to += 1

        # If the curr node and the next node ( to be deleted exists )
        # then delete it, else return a False
        if curr and curr.next:
            # It is possible that we will delete the tail, so update that
            if curr.next == self.tail:
                self.tail = curr
            curr.next = curr.next.next
            return True
        return False

    # Function to print out the entire linked list
    def __str__(self) -> str:
        values = ""
        curr = self.head.next
        while curr:
            if curr.next:
                values += str(curr.value) + " -> "
            else:
                values += str(curr.value)
            curr = curr.next
        return values if len(values) > 0 else "Linked List empty"


# Initilized an empty linked list
# Console output: ""
linked_list = LinkedList()

# Add a node at the head
# Console output: "1"
linked_list.insert_head(value=1)

# Add two more nodes but at the tail
# Console output: "1 -> 2 -> 3"
linked_list.insert_tail(value=2)
linked_list.insert_tail(value=3)

# Remove the node at an index which is out of bound
# Console output: Doesn't do anything | None
linked_list.remove(index=4)

# Remove the node at middle index
# Console output: "1 -> 3"
linked_list.remove(index=1)

# Insert number 5 at tail and then get the last index value (tail)
# Console output: 5 AND then "1 -> 3 - 5"
linked_list.insert_tail(value=5)
print(linked_list.get(index=2))
print(linked_list)
