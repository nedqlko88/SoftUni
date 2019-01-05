import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8007;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Listening on port: " + port);

        String serverPath = "F:\\softUni\\Repository\\JavaWebBasics\\server-test\\src\\resources";

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                // read request
                String line;
                line = in.readLine();
                System.out.println(line);
                String fileName = line.split(" ")[1];
                System.out.println("FILE NAME: " + fileName);
                StringBuilder raw = new StringBuilder();
                raw.append(line);
                boolean isPost = line.startsWith("POST");
                int contentLength = 0;
                while (!(line = in.readLine()).equals("")) {
                    System.out.println(line);
                    raw.append(line).append(System.lineSeparator());
                    if (isPost) {
                        final String contentHeader = "Content-Length: ";
                        if (line.startsWith(contentHeader)) {
                            contentLength = Integer.parseInt(line.substring(contentHeader.length()));
                        }
                    }
                }
                StringBuilder body = new StringBuilder();
                if (isPost) {
                    int c = 0;
                    for (int i = 0; i < contentLength; i++) {
                        c = in.read();
                        body.append((char) c);
                    }
                }
                raw.append(body.toString());
                System.out.println();
                System.out.println(body);

                if (fileName.contains("favicon")) {
                    continue;
                }

                try {
                    List<String> content = Files.readAllLines(Paths.get(serverPath + fileName));

                    out.write("HTTP/1.1 200 OK\r\n");
                    out.write("Content-Type: text/html\r\n");
                    out.write("\r\n");
                    out.write(String.join("", content));
                } catch (IOException e) {
                    out.write("HTTP/1.1 301 Moved Permanently\r\n");
                    out.write("Content-Type: text/html\r\n");
                    out.write("Location: pesho.html\r\n");
                    out.write("\r\n");
                }
                // send response - zakomentareno, pravq si test i go vryshtam


//                out.write("Content-Disposition: attachment; filename=" + fileName.substring(1) + "\r\n");
//                out.write("Content-Length: " + (new File(serverPath + fileName).length()) + "\r\n");


//                out.write(new Date().toString());
//                if (isPost) {
//                    out.write("<br><u>" + body.toString() + "</u>");
//                } else {
//                    out.write("<form method='POST'>");
//                    out.write("<input name='name' type='text'/>");
//                    out.write("<input type='submit'/>");
//                    out.write("</form>");
//                }
                //
                // do not in.close();
                out.flush();
                out.close();
                socket.close();
                //
            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
            }
        }
    }
}
