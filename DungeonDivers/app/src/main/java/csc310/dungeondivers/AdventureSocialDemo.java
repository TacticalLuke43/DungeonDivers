package csc310.dungeondivers;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by rommo_000 on 3/30/2017.
 */

public class AdventureSocialDemo extends Fragment {

    ImageButton TobiasView;
    TextView tobiasConvo;
    ImageButton EpicWizardView;
    ImageButton DungeonDiverView;
    ImageButton AwesomeWarriorView;
    ImageButton PowerOrcView;
    ImageButton SneakyRogueView;
    ImageButton FireMageView;
    ImageButton SlayerSamView;

   

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.adventure_social_demo, container, false);

        TobiasView = (ImageButton) view.findViewById(R.id.TobiasView);
        TobiasView.setBackgroundResource(R.drawable.mhm);
        AnimationDrawable frameAnimation = (AnimationDrawable) TobiasView.getBackground();
        frameAnimation.start();

        EpicWizardView = (ImageButton) view.findViewById(R.id.EpicWizardView);
        EpicWizardView.setBackgroundResource(R.drawable.mef);
        AnimationDrawable frameAnimation2 = (AnimationDrawable) EpicWizardView.getBackground();
        frameAnimation2.start();

        DungeonDiverView = (ImageButton) view.findViewById(R.id.DungeonDiverView);
        DungeonDiverView.setBackgroundResource(R.drawable.rom);
        AnimationDrawable frameAnimation3 = (AnimationDrawable) DungeonDiverView.getBackground();
        frameAnimation3.start();

        AwesomeWarriorView = (ImageButton) view.findViewById(R.id.AwesomeWarriorView);
        AwesomeWarriorView.setBackgroundResource(R.drawable.whf);
        AnimationDrawable frameAnimation4 = (AnimationDrawable) AwesomeWarriorView.getBackground();
        frameAnimation4.start();

        PowerOrcView = (ImageButton) view.findViewById(R.id.PowerOrcView);
        PowerOrcView.setBackgroundResource(R.drawable.wom);
        AnimationDrawable frameAnimation5 = (AnimationDrawable) PowerOrcView.getBackground();
        frameAnimation5.start();

        SneakyRogueView = (ImageButton) view.findViewById(R.id.SneakyRogueView);
        SneakyRogueView.setBackgroundResource(R.drawable.rhf);
        AnimationDrawable frameAnimation6 = (AnimationDrawable) SneakyRogueView.getBackground();
        frameAnimation6.start();

        FireMageView = (ImageButton) view.findViewById(R.id.FireMageView);
        FireMageView.setBackgroundResource(R.drawable.mom);
        AnimationDrawable frameAnimation7 = (AnimationDrawable) FireMageView.getBackground();
        frameAnimation7.start();

        SlayerSamView = (ImageButton) view.findViewById(R.id.SlayerSamView);
        SlayerSamView.setBackgroundResource(R.drawable.wef);
        AnimationDrawable frameAnimation8 = (AnimationDrawable) SlayerSamView.getBackground();
        frameAnimation8.start();





        TobiasView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    intent = new Intent(getContext(), TobiasMessage.class);
                }
                startActivity(intent);



            }
        });








        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }



    // tobiasConvo = (TextView) view.findViewById(R.id.TobiasConvo);

//  convoEditText = (EditText) view.findViewById(R.id.convoEditText);

    //  sendButton = (Button) view.findViewById(R.id.sendButton);
    //  cancelButton = (Button) view.findViewById(R.id.cancelButton);

    //  sendButton.setVisibility(View.INVISIBLE);
    //  cancelButton.setVisibility(View.INVISIBLE);

    public void showTobiasConvo(View view)
    {
        //TextView lukeConversation = (TextView) findView
        tobiasConvo.setText("Hey\nHey\nwant to go find a dungeon\nYEAH!!\n");
    }

}
