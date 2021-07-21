import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Theater {
	private static int ticketNumber;
	
	public static void main(String argv[]) {
		Member[] users = new Member[1000];
		int command, movieNum, userProgram, userExist, customerNum, isManager, test;
		int cntUser = 0, userNum = 0, movieReserveProgram = 0, theaterAdmin = 0;
		Scanner sc = new Scanner(System.in);
		String id, password, seat, enter;
		Movie[] movies = initMovieList();
		cntUser = initUserList(users, movies);
		double rate;

		while (movieReserveProgram == 0) {
			try {
				System.out.println("******영화 예매 프로그램******");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 종료");
				System.out.print("메뉴를 선택해주세요: ");
				command = sc.nextInt();
				switch (command) {
					case 1:
						System.out.println();
						System.out.println("******로그인******");
						enter = sc.nextLine();
						System.out.print("ID: ");
						id = sc.nextLine();
						System.out.print("Password: ");
						password = sc.nextLine();

						userExist = 0;
						for (int i = 0; i < cntUser; i++) {
							if (users[i].equals(id, password)) {
								userExist++;
								userNum = i;
								break;
							}
						}
						if(userExist != 1){
						throw (new InvalidLoginException());
						}
						else{
							userProgram = 0;
							while (userProgram == 0) {
								try {
									System.out.println();
									System.out.println("******유저 프로그램******");
									System.out.println("1. 영화 목록");
									System.out.println("2. 예매 확인");
									System.out.println("3. 영화관 관리");
									System.out.println("4. 예매 취소");
									System.out.println("5. 종료");
									System.out.print("메뉴를 선택해주세요: ");
									command = sc.nextInt();

									switch (command) {
										case 1:
											System.out.println();
											System.out.println("******영화 목록******");
											for (int i = 0; i < movies.length; i++) {
												System.out.println(movies[i].toString());
											}
											System.out.println("1. 예매");
											System.out.println("2. 종료");
											System.out.print("메뉴를 선택해주세요: ");
											command = sc.nextInt();

											if (command == 1) {
												System.out.println();
												System.out.println("******영화 목록******");
												for (int i = 0; i < movies.length; i++) {
													System.out.println((i + 1) + ". " + movies[i].toString());
												}
												System.out.print("예매할 영화를 선택해주세요: ");
												movieNum = sc.nextInt();
												
												if (users[userNum] instanceof Manager) {
													rate = Math.round((movies[movieNum - 1].getCntSeat() / (movies.length * 36.0)) * 10000) / 100.0;
													System.out.println("\n\"" + movies[movieNum - 1].getTitle() + "\" 영화의 좌석 예매 점유율: " + rate + "%");
													System.out.println("\"" + movies[movieNum - 1].getTitle() + "\" 영화의 총 매출액: " + movies[movieNum - 1].getCntSeat() * 10000 + "\n");
												}
												
												if(movies[movieNum-1].getCntSeat() == 36) {
													System.out.println("해당 영화는 매진입니다.");
													System.out.println("예약을 하면 임의의 자리를 예매 받을 수 있습니다.");
													System.out.println("예약을 진행하시겠습니까? (1. 예/ 2. 아니오)");
													command = sc.nextInt();
													if(command == 1) {
														setAllWaitingList(users, movies, cntUser);
														users[userNum].setTitle(movies[movieNum-1].getTitle());
														System.out.print("몇 분간 대기하시겠습니까? ");
														users[userNum].setTime(sc.nextInt());
														movies[movieNum-1].addMember(users[userNum]);
														System.out.println("예약이 완료되었습니다.");
													}
												}
												else {
													System.out.println(movies[movieNum - 1].toString());
													movies[movieNum - 1].showSeats();
													while (true) {
														try {
															System.out.print("좌석을 선택해주세요(ex A1): ");
															seat = sc.next();
															if ((int) (seat.charAt(0)) < 65 || (int) (seat.charAt(0)) > 70 || (int) (seat.charAt(1)) < 49 || (int)(seat.charAt(1)) > 54) {
																throw (new NotExistSeatException(seat));
															} else if (movies[movieNum - 1].isReserved(seat.charAt(0), Character.getNumericValue(seat.charAt(1)))) {
																throw (new DuplicatedReservationException(seat));
															} else {
																break;
															}
														}
														catch (NotExistSeatException e){
															System.out.println(e.getMessage());
														}
														catch (DuplicatedReservationException e){
															System.out.println(e.getMessage());
														}
													}
													ticketNumber++;
													users[userNum].reserveTicket(movieNum-1, seat);
												}
											} else if (command == 2) {
												System.out.println("유저 프로그램으로 돌아갑니다.");
											} else {
												throw (new InvalidMenuException(command));
											}
											break;

										case 2:
											if (users[userNum] instanceof Manager) {
												System.out.println("\n관리자가 발행한 티켓 수: " + users[userNum].getCntTicket());
												System.out.println("매출액: " + (users[userNum].getCntTicket() * 10000));
											}

											System.out.println("\n******예매 목록******");
											users[userNum].showTicketList();

											enter = sc.nextLine();
											System.out.print("\nPress enter to go back to User program");
											while (true) {
												enter = sc.nextLine();
												if (enter.length() == 0) break;
											}
											break;

										case 3:
											if (users[userNum] instanceof User) {
												throw (new InvalidMenuException());
											}
											theaterAdmin = 0;
											while (theaterAdmin == 0) {
                                                try {
                                                    System.out.println("\n*******영화관 관리*******");
                                                    System.out.println("1. 영화관 정보");
                                                    System.out.println("2. 유저 정보");
                                                    System.out.println("3. 종료");
                                                    System.out.print("메뉴를 선택해주세요: ");
                                                    command = sc.nextInt();
                                                    if (command == 1) {
                                                        System.out.println("점유된 전체 좌석 수: " + ticketNumber);
                                                        rate = Math.round((ticketNumber / (movies.length * 36.0)) * 10000) / 100.0;
                                                        System.out.println("전체 좌석 예매 점유율: " + rate + "%");
                                                        System.out.println("영화관 총 매출액: " + ticketNumber * 10000);
                                                        showReservationRate(movies);
                                                        enter = sc.nextLine();
                                                        System.out.print("Press enter to go back to Theater Management");
                                                        while (true) {
                                                            enter = sc.nextLine();
                                                            if (enter.length() == 0) break;
                                                        }
                                                    } else if (command == 2) {
                                                        enter = sc.nextLine();
                                                        System.out.print("찾으려는 id: ");
                                                        id = sc.nextLine();
                                                        customerNum = -1;
                                                        for (int i = 0; i < cntUser; i++) {
                                                            if (users[i].equalsId(id)) {
                                                                customerNum = i;
                                                                break;
                                                            }
                                                        }
                                                        if (customerNum == -1) {
                                                            System.out.println("동일한 ID를 가진 유저가 존재하지 않습니다.");
                                                            System.out.println("이전 페이지로 돌아갑니다.");
                                                        } else {
                                                            System.out.println(id + "고객님이 발행한 티켓 수: " + users[customerNum].getCntTicket());
                                                            if(users[customerNum].getCntTicket()!=0) {
                                                                System.out.println("-------------------------------------------");
                                                                users[customerNum].showTicketList();
                                                                System.out.println("-------------------------------------------");
                                                            }
                                                            System.out.print("Press enter to go back to Theater Management");
                                                            while (true) {
                                                                enter = sc.nextLine();
                                                                if (enter.length() == 0) break;
                                                            }
                                                        }
                                                    } else if (command == 3) {
                                                        theaterAdmin++;
                                                    } else {
                                                        throw (new InvalidMenuException(command));
                                                    }
                                                }
                                                catch (InvalidMenuException e){
                                                    System.out.println(e.getMessage());
                                                }
											}
											break;
											
										case 4:
											test = users[userNum].showTicketList_();
											if(test != -1) {
												System.out.println("\n어떤 티켓을 취소하시겠습니까? (돌아가기: 0)");
												command = sc.nextInt();
												if(command > users[userNum].getCntTicket()) {
													System.out.println("목록에 없는 티켓입니다.\n유저 프로그램으로 돌아갑니다.");
												}
												else if(command != 0) {
													users[userNum].cancelTicket(command - 1);
												}
											}
											break;
											
										case 5:
											System.out.println("영화 예매 프로그램으로 돌아갑니다.\n");
											userProgram++;
											break;

										default:
											throw (new InvalidMenuException(command));
									}
								}
								catch (InvalidMenuException e){
									System.out.println(e.getMessage());
								}
							}
						}
						break;

					case 2:
						System.out.println();
						System.out.println("******회원 가입******");
						enter = sc.nextLine();

						while (true) {
							try {
								System.out.print("ID: ");
								id = sc.nextLine();

								userExist = 0;
								for (int i = 0; i < cntUser; i++) {
									if (users[i].equalsId(id)) {
										userExist++;
										break;
									}
								}
								if (userExist == 1) {
									throw (new DuplicatedIdException(id));
								} else {
									break;
								}
							}
							catch (DuplicatedIdException e){
								System.out.println(e.getMessage());
							}
						}
						System.out.print("Password: ");
						password = sc.nextLine();

						while(true) {
							System.out.print("Manager: ");
							isManager = sc.nextInt();
							if (isManager == 1) {
								users[cntUser] = new Manager(id, password, movies);
								break;
							} else if (isManager == 0) {
								users[cntUser] = new User(id, password, movies);
								break;
							} else {
								System.out.println("0과 1 중에 하나를 입력해주세요 (Manager인 경우 1을 입력하세요.)");
							}
						}
						cntUser++;
						System.out.println();
						break;

					case 3:
						System.out.println("영화 예매 프로그램을 종료합니다.");
						movieReserveProgram++;
						break;

					default:
						throw (new InvalidMenuException(command));
				}
			}
			catch (InvalidMenuException e){
				System.out.println(e.getMessage());
			}
			catch (InvalidLoginException e){
				System.out.println(e.getMessage());
			}
		}
		saveInfo(users, cntUser);
		sc.close();
	}

	private static void setAllWaitingList(Member[] users, Movie[] movies, int cntUser) {
		for(int k=0; k<movies.length; k++) {
			for(int i=0; i<movies[k].getWaitingSize(); i++) {
				if(!movies[k].isAlive(i)) {
					for(int j=0; j<cntUser; j++) {
						if(movies[k].getMember(i).getId_().equals(users[j].getId_())) {
							if(users[j].getClass() == Manager.class) {
								users[j] = new Manager(movies[k].getMember(i));
							}
							else {
								users[j] = new User(movies[k].getMember(i));
							}
						}
					}
					movies[k].removeMember(i);
					i--;
				}
			}
		}
		
	}

	private static void showReservationRate(Movie[] movies) {
		int[] seatNums = new int[movies.length];
		int preNum=-1, cnt=1;

		System.out.println("\n예매율 현황");
		System.out.println("-------------------------------------------");
		for(int i=0; i<movies.length; i++){
			seatNums[i] = movies[i].getCntSeat();
		}
		Arrays.sort(seatNums);

		for(int i =seatNums.length-1; i > 0; i--){
			if(preNum != seatNums[i]){
				for (int j = 0; j < movies.length; j++) {
					if (seatNums[i] == movies[j].getCntSeat()) {
						System.out.println(cnt + "위: " + movies[j].getTitle() + "(예매좌석:" + movies[j].getCntSeat() + ")");
						cnt++;
						if(cnt>3){
							break;
						}
					}

				}
			}
			preNum = seatNums[i];
			if(cnt>3){
				break;
			}
		}
		System.out.println("-------------------------------------------");
	}

	private static Movie[] initMovieList(){
		int movieNum;
		String tmp;
		String[] input;
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new FileInputStream("MovieList.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("영화 목록이 존재하지 않습니다.");
			System.exit(0);
		}
		movieNum = inputStream.nextInt();
		Movie[] movies = new Movie[movieNum];

		tmp = inputStream.nextLine();
		for(int i=0; i<movieNum; i++){
			tmp = inputStream.nextLine();
			input = tmp.split("/");
			movies[i] = new Movie(input[0],Integer.parseInt(input[1]),Integer.parseInt(input[2]));
		}
		inputStream.close();
		return movies;
	}

	private static int initUserList(Member[] members, Movie[] movies) {
		int userNum, ticketNum, existTicketList=0;
		String tmp;
		String input[];
		Scanner inputUser = null, inputTicket = null;

		try {
			inputUser = new Scanner(new FileInputStream("UserList.txt"));
		}
		catch (FileNotFoundException e) {
			return 0;
		}
		try {
			inputTicket = new Scanner(new FileInputStream("TicketList.txt"));
		}
		catch (FileNotFoundException e) {
			existTicketList++;
		}
		if(!inputUser.hasNextInt()) return 0;

		userNum = inputUser.nextInt();
		tmp = inputUser.nextLine();
		if(existTicketList == 0) Theater.setTicketNumber(inputTicket.nextInt());
		
		for(int i=0; i<userNum; i++){
			tmp = inputUser.nextLine();
			input = tmp.split(" ");
			if(input[0].equals("1")){
				members[i] = new Manager(input[1],input[2], movies);
			}
			else{
				members[i] = new User(input[1],input[2], movies);
			}
			if(existTicketList == 0) {
				ticketNum = inputTicket.nextInt();
				tmp = inputTicket.nextLine();
				for (int j = 0; j < ticketNum; j++) {
					tmp = inputTicket.nextLine();
					input = tmp.split("/");
					members[i].reserveTicket(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), input[3], Integer.parseInt(input[4]));
				}
			}
		}
		inputUser.close();
		inputTicket.close();
		return userNum;
	}

	private static void saveInfo(Member[] users, int cntUser) {
		PrintWriter outputUser = null;
		PrintWriter outputTicket = null;
		PrintWriter outputDisplay = null;
		
		try {
			outputUser = new PrintWriter(new FileOutputStream("UserList.txt"));
			outputTicket= new PrintWriter(new FileOutputStream("TicketList.txt"));
			outputDisplay = new PrintWriter(new FileOutputStream("Display.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		outputUser.println(cntUser);
		for(int i=0; i<cntUser; i++){
			outputUser.println(users[i].toSaveUserInfo());
		}
		
		outputTicket.println(Theater.getTicketNumber());
		for(int i=0; i<cntUser; i++){
			outputTicket.println(users[i].toSaveTicketInfo());
		}
		for(int i=0; i<cntUser; i++) {
			outputDisplay.print(users[i].toDisplay());
		}

		outputTicket.close();
		outputUser.close();
		outputDisplay.close();
	}
	
	public static void setTicketNumber(int ticketNumber) {
		Theater.ticketNumber = ticketNumber; 
	}
	public static int getTicketNumber() {
		return Theater.ticketNumber;
	}
}
