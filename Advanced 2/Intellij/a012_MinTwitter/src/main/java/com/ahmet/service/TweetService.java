package com.ahmet.service;

import com.ahmet.repository.TweetRepository;
import com.ahmet.repository.entity.Tweet;
import com.ahmet.repository.entity.UserProfile;
import com.ahmet.repository.view.VwTweet;
import com.ahmet.utility.MyFactoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TweetService extends MyFactoryService<TweetRepository, Tweet, Long> {

    private UserProfileService userProfileService;

    public TweetService() {
        super(new TweetRepository());
        userProfileService = new UserProfileService();
    }

    /**
     * !!!!! DİKKAT !!!!!!
     * Bir listeden başka servislerden bilgi çekmesi bekleniyorsa,
     * bu işlem her bir kayıt başına belli bir maliyete sebep
     * olacaktır. Bu nedenle bu işlem (her seferinde bir kaydın
     * çekilmesi) doğru değildir. Burada 2 çözüm yolu karşımıza çıkar:
     * 1- JOIN kullanarak iki tablonun birleştirilmesi
     * 2- Arama yapılacak listenin tümden çekilerek filter ile
     * bilgilerin çekilmesi.
     * @return
     */
    public List<VwTweet> findAllViewTweet() {
        List<VwTweet> result = new ArrayList<>();
        List<Tweet> tweetList = getRepository().findAll(); // Bütün tweet'leri çeker.
        List<UserProfile> userProfileList = userProfileService.findAll();
        tweetList.forEach(t -> {
            /**
             * Çok fazla maliyetli bir işlemdir (alttaki satır), tercih edilmemeli.
             * Veri sayısı çok fazla olduğu zaman işlem çok zaman alır. Su bir
             * çözüm olabilir: İşlem yapılacak tablonun gerekli sütunlarını çekip,
             * bunları bir HashMap'e atıp, bunun üzerinde arama yapmak çok daha
             * kısa zaman alır.
             */
//            UserProfile userProfile = userProfileService.findById(t.getUserid()).get();
            UserProfile userProfile = userProfileList.stream()
                    .filter(x -> x.getId().equals(t.getUserid()))
                    .findFirst().get();
            VwTweet viewtwt = VwTweet.builder()
                    .id(t.getId())
                    .image(t.getImage())
                    .content(t.getContent())
                    .sharedate(t.getSharedate())
                    .retweetid(t.getRetweetid())
                    .tweetcomment(t.getTweetcomment())
                    .userid(t.getUserid())
                    .retweet(t.getRetweet())
                    .tweetview(t.getTweetview())
                    .tweetlike(t.getTweetlike())
                    .quotedtweetid(t.getQuotedtweetid())
                    .profileimg(userProfile.getProfileimg())
                    .nickName(userProfile.getName() + " " + userProfile.getSurname())
                    .username(userProfile.getUsername())
                    .build();
            result.add(viewtwt);
        });
        return result;
    }

    public Optional<VwTweet> findVwTweetById(Long id) {
        Optional<Tweet> tweet = findById(id); // findById() -> MyFactoryService'den geliyor.
        if(tweet.isEmpty()) {
            return Optional.empty();
        }
        UserProfile userProfile = userProfileService.findById(tweet.get().getUserid()).get();
        VwTweet viewtwt = VwTweet.builder()
                .id(tweet.get().getId())
                .image(tweet.get().getImage())
                .content(tweet.get().getContent())
                .sharedate(tweet.get().getSharedate())
                .retweetid(tweet.get().getRetweetid())
                .tweetcomment(tweet.get().getTweetcomment())
                .userid(tweet.get().getUserid())
                .retweet(tweet.get().getRetweet())
                .tweetview(tweet.get().getTweetview())
                .tweetlike(tweet.get().getTweetlike())
                .quotedtweetid(tweet.get().getQuotedtweetid())
                .profileimg(userProfile.getProfileimg())
                .nickName(userProfile.getName() + " " + userProfile.getSurname())
                .username(userProfile.getUsername())
                .build();
        return Optional.of(viewtwt);
    }

}
