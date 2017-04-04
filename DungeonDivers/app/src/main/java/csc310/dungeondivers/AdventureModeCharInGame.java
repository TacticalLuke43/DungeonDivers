package csc310.dungeondivers;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class AdventureModeCharInGame extends Fragment {

    adventureActivity2 activity2;
    Player player;
    TextView charName;
    ImageView charIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.adventure_mode_char_in_game, container, false);
        charName = (TextView) view.findViewById(R.id.charInGameName);
        charIcon = (ImageView) view.findViewById(R.id.charInGameIcon);
        return view;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity2 = (adventureActivity2) getActivity();
        player = activity2.getPlayer();
        charName.setText(player.getName());
        charIcon.setBackgroundResource(getResources().getIdentifier(player.getRaceClassGender(), "drawable", getContext().getPackageName()));
        AnimationDrawable frameAnimation = (AnimationDrawable) charIcon.getBackground();
        frameAnimation.start();

    }

}
