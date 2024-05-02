# import nltk
# from nltk.chat.util import Chat, reflections

# pairs = [
#     [
#         r"Hi|Hello|Heya|Hey|Hey there|Hola",
#         ["Hello there, I'm your Real Estate Assistant.\n"]
#     ],
#     [
#         r"How are you feeling today?|How are you?|How do you feel?",
#         ["Well, I'm a bot I don't really have feelings but Thanks for asking\n"]
#     ],
#     [
#         r"What can you do|What are your expertise|How can you help",
#         ["I'm a Real Estate Assistant, who can guide you in your real estate queries\n"]
#     ],
#     [
#         r"Thanks|Thank You|Thank You for your help",
#         ["Glad I could help. Feel free to investigate further.\n"]
#     ],
#     [
#         r"Can you recommend a real estate expert in my location?",
#         ["Well, I'm here to assist, consulting a local real estate expert for specific advice is recommended. I can provide general information and insights.\n",]
#     ],
#     [
#         r"What specific services do you offer in real estate?",
#         [" I specialize in a range of real estate services, including property search, market analysis, and advice on buying, selling, or renting. Where are you currently located or interested in exploring real estate?\n",]
#     ],
#     [
#         r"How is the real estate market today",
#         ['The real estate market is dynamic. Are you looking to buy, sell, or rent a property in this area?\n',]
#     ],
#     [
#         r"Goodbye|Bye|BBye|See ya",
#         ["Have a Good Day....!\n"]
#     ], [
#         r".*",
#         ["I couldn't understand that. Would you please Rephrase\n"]
#     ]
# ]

# print("\n--------------------")
# print("Hello!")
# print("I'm a RealtyBot, your REAL ESTATE Assistant")
# print("You can start by saying 'Hi' or 'Hello' and end by saying 'Quit' or 'Exit'\n")
# chat = Chat(pairs)

# while True:
#     user_input = input("> ")
#     if(user_input == 'exit' or user_input == 'quit'):
#         break
#     response = chat.respond(user_input)
#     print(response)

# # chat.converse("\n")


# # $ C:/Python/python.exe "e:/Study Material.org/TE/Sem II/AI Codes/Final Code/practice.py"

# # --------------------
# # Hello!
# # I'm a RealtyBot, your REAL ESTATE Assistant
# # You can start by saying 'Hi' or 'Hello' and end by saying 'Quit' or 'Exit'

# # > hi
# # Hello there, I'm your Real Estate Assistant.

# # > how are you today
# # Well, I'm a bot I don't really have feelings but Thanks for asking

# # > what are your expertise
# # I'm a Real Estate Assistant, who can guide you in your real estate queries

# # > what specific services do you offer in real estate
# #  I specialize in a range of real estate services, including property search, market analysis, and advice on buying, selling, or renting. Where are you currently located or interested in exploring real estate?

# # > how is the real estate market today
# # The real estate market is dynamic. Are you looking to buy, sell, or rent a property in this area?

# # > can you recommend a real estate exper in my location
# # I couldn't understand that. Would you please Rephrase

# # > can you recommend a real estate expert in my location 
# # Well, I'm here to assist, consulting a local real estate expert for specific advice is recommended. I can provide general information and insights.

# # > thanks
# # Glad I could help. Feel free to investigate further.

# # > goodbye
# # Have a Good Day....!

# # > quit

# # Dell@DESKTOP-M5BP7RG MINGW64 /e/Study Material.org/TE/Sem II/AI Codes/Final Code
# # $




# MAX_MOVES = 1000

# def printBoard(arr, move_name = ""):
#     if(move_name != ""):
#         print("Direction : ",move_name, end="")
#     for _ in range(9):
#         if(_ % 3 == 0):
#             print()
#         if(arr[_] == -1):
#             print("_", end="  ")
#         else:
#             print(arr[_], end="  ")

# def calculate_h(start, goal):
#     h = 0
#     for i in range(9):
#         for j in range(9):
#             if(start[i] != -1 and start[i] == goal[j]):
#                 h += abs(j-i) // 3 + abs(j-i) % 3
#     return h

# def moveLeft(copy, blank):
#     copy[blank], copy[blank-1] = copy[blank-1], copy[blank]

# def moveRight(copy, blank):
#     copy[blank], copy[blank+1] = copy[blank+1], copy[blank]

# def moveUp(copy, blank):
#     copy[blank], copy[blank-3] = copy[blank-3], copy[blank]

# def moveDown(copy, blank):
#     copy[blank], copy[blank+3] = copy[blank+3], copy[blank]

# def moveTile(start, goal):
#     blank = start.index(-1)
#     row = blank // 3
#     col = blank % 3
#     c1, c2, c3, c4 = start[:], start[:], start[:], start[:]
#     h1, h2, h3, h4 = 100, 100, 100, 100
#     if(col - 1 >= 0):
#         moveLeft(c1, blank)
#         h1 = calculate_h(c1, goal)
#     if(col + 1 < 3):
#         moveRight(c2, blank)
#         h2 = calculate_h(c2 , goal)
#     if(row -1 >= 0):
#         moveUp(c3, blank)
#         h3 = calculate_h(c3 , goal)
#     if(row + 1 < 3):
#         moveDown(c4, blank)
#         h4 = calculate_h(c4 , goal)
#     h = min(h1, h2, h3, h4)
#     if(h == h1):
#         moveLeft(start, blank)
#         return "Left"
#     if(h == h2):
#         moveRight(start, blank)
#         return "Right"
#     if(h == h3):
#         moveUp(start, blank)
#         return "Up"
#     if(h == h4):
#         moveDown(start, blank)
#         return "Down"


# def A_Star(start, goal, g = 0):
#     move_name = moveTile(start, goal)
#     g += 1
#     h = calculate_h(start, goal)
#     f = g+h
#     print("\n\ng = ",g,", h = ",h,", f = ",f)
#     printBoard(start, move_name)
#     if(h == 0 or g >= MAX_MOVES):
#         print("\n\nSolved in ",g," moves")
#         return
#     A_Star(start, goal, g)

# def main():
#     start = [2,8,3,1,6,4,7,-1,5]
#     goal = [1,2,3,8,-1,4,7,6,5]
#     # print("Enter the start state : (Enter -1 for blank position)")
#     # for _ in range(9):
#     #     start.append(int(input()))
#     # print("Enter the goal state : (Enter -1 for blank position)")
#     # for _ in range(9):
#     #     goal.append(int(input()))
#     print("\nStart state : ")
#     printBoard(start)
#     print("\n\n+-------------------------")
#     print("\nGoal state : ")
#     printBoard(goal)
#     print("\n\n-------------------------")
#     print("Starting A* Algorithm : ")
#     print("\ng = 0, h = 0, f = 0", end="")
#     printBoard(start)
#     A_Star(start, goal)

# main()