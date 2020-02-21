/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    // find user with Most Likes
    //  key: UserId ; Value: sum of likes from all comments
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
    
        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userLikesCount.keySet()) {
            if (userLikesCount.get(id) > max) {
                max = userLikesCount.get(id);
                maxId = id;
            }
        }
        System.out.println("User with most likes: " + max + "\n" 
            + users.get(maxId));
    }
    
    // find 5 comments which have the most likes
    public void getFiveMostLikedComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override 
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });
        
        System.out.println("5 most likes comments: ");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
    }
    
    public void topFiveInactiveUsersOnPostsNumber() {
        
        Map<Integer, Post> postsMap = DataStore.getInstance().getPosts();
        Map<Integer, User> usersMap = DataStore.getInstance().getUsers();
        Map<Integer, Integer> inactiveUserCount = new HashMap<>();
        
        for(Post p : postsMap.values()) {
            int posts = 0;
            if (inactiveUserCount.containsKey(p.getUserId())) {
                posts = inactiveUserCount.get(p.getUserId());
            }
            posts += 1;
            inactiveUserCount.put(p.getUserId(), posts);
        }
        
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(inactiveUserCount.entrySet()); 
  
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        System.out.println("Top 5 inactive users based on total posts number: ");
        int count = 0;
        for (Map.Entry<Integer, Integer> aa : list) { 
            System.out.println(usersMap.get(aa.getKey()) + "; Posts: " + aa.getValue());
            if(count == 5) {
                break;
            }
            count++;
        }
    }
}
