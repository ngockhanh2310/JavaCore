package org.workspace.exercise;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLDownloader extends JFrame {
    private JTextField urlField;
    private JTextArea contentArea;
    private JTextArea linksArea;
    private JButton downloadBtn;
    private JButton saveBtn;
    private JProgressBar progressBar;
    private String downloadedContent = "";

    public URLDownloader() {
        setTitle("URL Downloader & Link Extractor");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    public static void main(String[] args) {
        // Sử dụng Look and Feel của hệ thống
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            URLDownloader app = new URLDownloader();
            app.setVisible(true);
        });
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Panel nhập URL
        JPanel urlPanel = new JPanel(new BorderLayout(5, 5));
        JLabel urlLabel = new JLabel("URL:");
        urlField = new JTextField("https://example.com");
        downloadBtn = new JButton("Download");
        saveBtn = new JButton("Lưu File");
        saveBtn.setEnabled(false);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(downloadBtn);
        buttonPanel.add(saveBtn);

        urlPanel.add(urlLabel, BorderLayout.WEST);
        urlPanel.add(urlField, BorderLayout.CENTER);
        urlPanel.add(buttonPanel, BorderLayout.EAST);

        // Progress bar
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);

        // Panel nội dung
        JPanel contentPanel = new JPanel(new BorderLayout(5, 5));
        contentPanel.setBorder(BorderFactory.createTitledBorder("Nội dung đã tải"));
        contentArea = new JTextArea();
        contentArea.setEditable(false);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane contentScroll = new JScrollPane(contentArea);
        contentPanel.add(contentScroll, BorderLayout.CENTER);

        // Panel liên kết
        JPanel linksPanel = new JPanel(new BorderLayout(5, 5));
        linksPanel.setBorder(BorderFactory.createTitledBorder("Các liên kết tìm thấy"));
        linksArea = new JTextArea();
        linksArea.setEditable(false);
        linksArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane linksScroll = new JScrollPane(linksArea);
        linksPanel.add(linksScroll, BorderLayout.CENTER);

        // Split pane cho 2 vùng nội dung
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                contentPanel, linksPanel);
        splitPane.setDividerLocation(300);
        splitPane.setResizeWeight(0.5);

        // Thêm các thành phần vào main panel
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(urlPanel, BorderLayout.NORTH);
        topPanel.add(progressBar, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);

        add(mainPanel);

        // Xử lý sự kiện
        downloadBtn.addActionListener(e -> downloadContent());
        saveBtn.addActionListener(e -> saveToFile());

        // Enter để download
        urlField.addActionListener(e -> downloadContent());
    }

    private void downloadContent() {
        String urlString = urlField.getText().trim();

        if (urlString.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng nhập URL!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Disable các nút trong khi download
        downloadBtn.setEnabled(false);
        saveBtn.setEnabled(false);
        progressBar.setVisible(true);
        progressBar.setIndeterminate(true);
        contentArea.setText("Đang tải...");
        linksArea.setText("");

        // Download trong thread riêng
        new Thread(() -> {
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream(), "UTF-8"));
                    StringBuilder content = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    reader.close();

                    downloadedContent = content.toString();

                    // Cập nhật UI trong EDT
                    SwingUtilities.invokeLater(() -> {
                        contentArea.setText(downloadedContent);
                        contentArea.setCaretPosition(0);
                        extractLinks(downloadedContent);
                        saveBtn.setEnabled(true);
                        JOptionPane.showMessageDialog(this,
                                "Download thành công!",
                                "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    });
                } else {
                    SwingUtilities.invokeLater(() -> {
                        contentArea.setText("Lỗi HTTP: " + responseCode);
                        JOptionPane.showMessageDialog(this,
                                "Không thể tải nội dung. Mã lỗi: " + responseCode,
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    });
                }

                connection.disconnect();

            } catch (MalformedURLException ex) {
                SwingUtilities.invokeLater(() -> {
                    contentArea.setText("URL không hợp lệ!");
                    JOptionPane.showMessageDialog(this,
                            "URL không hợp lệ: " + ex.getMessage(),
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                });
            } catch (IOException ex) {
                SwingUtilities.invokeLater(() -> {
                    contentArea.setText("Lỗi kết nối: " + ex.getMessage());
                    JOptionPane.showMessageDialog(this,
                            "Lỗi kết nối: " + ex.getMessage(),
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                });
            } finally {
                SwingUtilities.invokeLater(() -> {
                    downloadBtn.setEnabled(true);
                    progressBar.setVisible(false);
                });
            }
        }).start();
    }

    private void extractLinks(String content) {
        List<String> links = new ArrayList<>();

        // Pattern cho URL đầy đủ (http, https)
        Pattern urlPattern = Pattern.compile(
                "(https?://[\\w\\-]+(\\.[\\w\\-]+)+[/#?]?[^\\s]*)",
                Pattern.CASE_INSENSITIVE);

        // Pattern cho href trong HTML
        Pattern hrefPattern = Pattern.compile(
                "href\\s*=\\s*['\"]([^'\"]+)['\"]",
                Pattern.CASE_INSENSITIVE);

        // Pattern cho src trong HTML
        Pattern srcPattern = Pattern.compile(
                "src\\s*=\\s*['\"]([^'\"]+)['\"]",
                Pattern.CASE_INSENSITIVE);

        // Tìm tất cả các URL
        Matcher urlMatcher = urlPattern.matcher(content);
        while (urlMatcher.find()) {
            String link = urlMatcher.group(1);
            if (!links.contains(link)) {
                links.add(link);
            }
        }

        // Tìm href
        Matcher hrefMatcher = hrefPattern.matcher(content);
        while (hrefMatcher.find()) {
            String link = hrefMatcher.group(1);
            if (!links.contains(link) && !link.startsWith("#")) {
                links.add(link);
            }
        }

        // Tìm src
        Matcher srcMatcher = srcPattern.matcher(content);
        while (srcMatcher.find()) {
            String link = srcMatcher.group(1);
            if (!links.contains(link)) {
                links.add(link);
            }
        }

        // Hiển thị kết quả
        StringBuilder result = new StringBuilder();
        result.append("Tìm thấy ").append(links.size()).append(" liên kết:\n\n");

        for (int i = 0; i < links.size(); i++) {
            result.append((i + 1)).append(". ").append(links.get(i)).append("\n");
        }

        if (links.isEmpty()) {
            result.append("Không tìm thấy liên kết nào.");
        }

        linksArea.setText(result.toString());
        linksArea.setCaretPosition(0);
    }

    private void saveToFile() {
        if (downloadedContent.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Không có nội dung để lưu!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu file");
        fileChooser.setSelectedFile(new File("downloaded_content.html"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileToSave))) {
                writer.write(downloadedContent);
                JOptionPane.showMessageDialog(this,
                        "Lưu file thành công!\nĐường dẫn: " + fileToSave.getAbsolutePath(),
                        "Thành công",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Lỗi khi lưu file: " + ex.getMessage(),
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
