PGDMP                          w            PW-2019-2-Trabalho    11.5    11.5 9    ]           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ^           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            _           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            `           1262    24747    PW-2019-2-Trabalho    DATABASE     �   CREATE DATABASE "PW-2019-2-Trabalho" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
 $   DROP DATABASE "PW-2019-2-Trabalho";
             postgres    false            �            1259    24748    consulta    TABLE     �   CREATE TABLE public.consulta (
    id integer NOT NULL,
    data date NOT NULL,
    hora time without time zone NOT NULL,
    posconsulta text NOT NULL,
    preconsulta text NOT NULL,
    medico integer NOT NULL,
    paciente integer NOT NULL
);
    DROP TABLE public.consulta;
       public         postgres    false            �            1259    24756    especialidade    TABLE     m   CREATE TABLE public.especialidade (
    id integer NOT NULL,
    descricao character varying(50) NOT NULL
);
 !   DROP TABLE public.especialidade;
       public         postgres    false            �            1259    24761    exame    TABLE     �   CREATE TABLE public.exame (
    id integer NOT NULL,
    descricao character varying(80) NOT NULL,
    nome character varying(50) NOT NULL,
    consulta integer NOT NULL
);
    DROP TABLE public.exame;
       public         postgres    false            �            1259    24766    medicamento    TABLE     f   CREATE TABLE public.medicamento (
    id integer NOT NULL,
    nome character varying(50) NOT NULL
);
    DROP TABLE public.medicamento;
       public         postgres    false            �            1259    24771    medicamentos    TABLE     i   CREATE TABLE public.medicamentos (
    receituario integer NOT NULL,
    medicamento integer NOT NULL
);
     DROP TABLE public.medicamentos;
       public         postgres    false            �            1259    24776    medico    TABLE     �  CREATE TABLE public.medico (
    id integer NOT NULL,
    altura double precision NOT NULL,
    historico text NOT NULL,
    nascimento date NOT NULL,
    nome character varying(50) NOT NULL,
    peso double precision NOT NULL,
    sexo character varying(9) NOT NULL,
    telefone character varying(14) NOT NULL,
    crm character varying(6) NOT NULL,
    especialidade integer NOT NULL
);
    DROP TABLE public.medico;
       public         postgres    false            �            1259    24784    paciente    TABLE     =  CREATE TABLE public.paciente (
    id integer NOT NULL,
    altura double precision NOT NULL,
    historico text NOT NULL,
    nascimento date NOT NULL,
    nome character varying(50) NOT NULL,
    peso double precision NOT NULL,
    sexo character varying(9) NOT NULL,
    telefone character varying(14) NOT NULL
);
    DROP TABLE public.paciente;
       public         postgres    false            �            1259    24842 	   permissao    TABLE     p   CREATE TABLE public.permissao (
    nome character varying(30) NOT NULL,
    descricao character varying(40)
);
    DROP TABLE public.permissao;
       public         postgres    false            �            1259    24847 
   permissoes    TABLE     }   CREATE TABLE public.permissoes (
    usuario character varying(20) NOT NULL,
    permissao character varying(30) NOT NULL
);
    DROP TABLE public.permissoes;
       public         postgres    false            �            1259    24792    receituario    TABLE     �   CREATE TABLE public.receituario (
    id integer NOT NULL,
    posologia text NOT NULL,
    validade date NOT NULL,
    consulta integer NOT NULL
);
    DROP TABLE public.receituario;
       public         postgres    false            �            1259    24800    seq_consulta_id    SEQUENCE     x   CREATE SEQUENCE public.seq_consulta_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.seq_consulta_id;
       public       postgres    false            �            1259    24802    seq_especialidade_id    SEQUENCE     }   CREATE SEQUENCE public.seq_especialidade_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.seq_especialidade_id;
       public       postgres    false            �            1259    24804    seq_exame_id    SEQUENCE     u   CREATE SEQUENCE public.seq_exame_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.seq_exame_id;
       public       postgres    false            �            1259    24806    seq_medicamento_id    SEQUENCE     {   CREATE SEQUENCE public.seq_medicamento_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.seq_medicamento_id;
       public       postgres    false            �            1259    24808    seq_paciente_id    SEQUENCE     x   CREATE SEQUENCE public.seq_paciente_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.seq_paciente_id;
       public       postgres    false            �            1259    24810    seq_receituario_id    SEQUENCE     {   CREATE SEQUENCE public.seq_receituario_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.seq_receituario_id;
       public       postgres    false            �            1259    24852    usuario    TABLE     �   CREATE TABLE public.usuario (
    nome_usuario character varying(20) NOT NULL,
    data_cadastro date NOT NULL,
    email character varying(60) NOT NULL,
    nome character varying(50) NOT NULL,
    senha character varying(20) NOT NULL
);
    DROP TABLE public.usuario;
       public         postgres    false            J          0    24748    consulta 
   TABLE DATA               ^   COPY public.consulta (id, data, hora, posconsulta, preconsulta, medico, paciente) FROM stdin;
    public       postgres    false    196   �@       K          0    24756    especialidade 
   TABLE DATA               6   COPY public.especialidade (id, descricao) FROM stdin;
    public       postgres    false    197   �@       L          0    24761    exame 
   TABLE DATA               >   COPY public.exame (id, descricao, nome, consulta) FROM stdin;
    public       postgres    false    198   A       M          0    24766    medicamento 
   TABLE DATA               /   COPY public.medicamento (id, nome) FROM stdin;
    public       postgres    false    199   <A       N          0    24771    medicamentos 
   TABLE DATA               @   COPY public.medicamentos (receituario, medicamento) FROM stdin;
    public       postgres    false    200   gA       O          0    24776    medico 
   TABLE DATA               s   COPY public.medico (id, altura, historico, nascimento, nome, peso, sexo, telefone, crm, especialidade) FROM stdin;
    public       postgres    false    201   �A       P          0    24784    paciente 
   TABLE DATA               a   COPY public.paciente (id, altura, historico, nascimento, nome, peso, sexo, telefone) FROM stdin;
    public       postgres    false    202   �A       X          0    24842 	   permissao 
   TABLE DATA               4   COPY public.permissao (nome, descricao) FROM stdin;
    public       postgres    false    210   CB       Y          0    24847 
   permissoes 
   TABLE DATA               8   COPY public.permissoes (usuario, permissao) FROM stdin;
    public       postgres    false    211   �B       Q          0    24792    receituario 
   TABLE DATA               H   COPY public.receituario (id, posologia, validade, consulta) FROM stdin;
    public       postgres    false    203   �B       Z          0    24852    usuario 
   TABLE DATA               R   COPY public.usuario (nome_usuario, data_cadastro, email, nome, senha) FROM stdin;
    public       postgres    false    212   	C       a           0    0    seq_consulta_id    SEQUENCE SET     =   SELECT pg_catalog.setval('public.seq_consulta_id', 1, true);
            public       postgres    false    204            b           0    0    seq_especialidade_id    SEQUENCE SET     B   SELECT pg_catalog.setval('public.seq_especialidade_id', 1, true);
            public       postgres    false    205            c           0    0    seq_exame_id    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.seq_exame_id', 1, false);
            public       postgres    false    206            d           0    0    seq_medicamento_id    SEQUENCE SET     @   SELECT pg_catalog.setval('public.seq_medicamento_id', 1, true);
            public       postgres    false    207            e           0    0    seq_paciente_id    SEQUENCE SET     =   SELECT pg_catalog.setval('public.seq_paciente_id', 4, true);
            public       postgres    false    208            f           0    0    seq_receituario_id    SEQUENCE SET     A   SELECT pg_catalog.setval('public.seq_receituario_id', 1, false);
            public       postgres    false    209            �
           2606    24755    consulta consulta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.consulta DROP CONSTRAINT consulta_pkey;
       public         postgres    false    196            �
           2606    24760     especialidade especialidade_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.especialidade
    ADD CONSTRAINT especialidade_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.especialidade DROP CONSTRAINT especialidade_pkey;
       public         postgres    false    197            �
           2606    24765    exame exame_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.exame
    ADD CONSTRAINT exame_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.exame DROP CONSTRAINT exame_pkey;
       public         postgres    false    198            �
           2606    24770    medicamento medicamento_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.medicamento
    ADD CONSTRAINT medicamento_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.medicamento DROP CONSTRAINT medicamento_pkey;
       public         postgres    false    199            �
           2606    24775    medicamentos medicamentos_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.medicamentos
    ADD CONSTRAINT medicamentos_pkey PRIMARY KEY (receituario, medicamento);
 H   ALTER TABLE ONLY public.medicamentos DROP CONSTRAINT medicamentos_pkey;
       public         postgres    false    200    200            �
           2606    24783    medico medico_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.medico DROP CONSTRAINT medico_pkey;
       public         postgres    false    201            �
           2606    24791    paciente paciente_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_pkey;
       public         postgres    false    202            �
           2606    24846    permissao permissao_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.permissao
    ADD CONSTRAINT permissao_pkey PRIMARY KEY (nome);
 B   ALTER TABLE ONLY public.permissao DROP CONSTRAINT permissao_pkey;
       public         postgres    false    210            �
           2606    24851    permissoes permissoes_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.permissoes
    ADD CONSTRAINT permissoes_pkey PRIMARY KEY (usuario, permissao);
 D   ALTER TABLE ONLY public.permissoes DROP CONSTRAINT permissoes_pkey;
       public         postgres    false    211    211            �
           2606    24799    receituario receituario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.receituario
    ADD CONSTRAINT receituario_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.receituario DROP CONSTRAINT receituario_pkey;
       public         postgres    false    203            �
           2606    24856    usuario usuario_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (nome_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    212            �
           2606    24827 (   medicamentos fk3o2hf4ytpk495jux9ymqnmbfg    FK CONSTRAINT     �   ALTER TABLE ONLY public.medicamentos
    ADD CONSTRAINT fk3o2hf4ytpk495jux9ymqnmbfg FOREIGN KEY (receituario) REFERENCES public.receituario(id);
 R   ALTER TABLE ONLY public.medicamentos DROP CONSTRAINT fk3o2hf4ytpk495jux9ymqnmbfg;
       public       postgres    false    2754    200    203            �
           2606    24822 (   medicamentos fk93c9qmcu3qln3tsrmaytp5lwp    FK CONSTRAINT     �   ALTER TABLE ONLY public.medicamentos
    ADD CONSTRAINT fk93c9qmcu3qln3tsrmaytp5lwp FOREIGN KEY (medicamento) REFERENCES public.medicamento(id);
 R   ALTER TABLE ONLY public.medicamentos DROP CONSTRAINT fk93c9qmcu3qln3tsrmaytp5lwp;
       public       postgres    false    199    2746    200            �
           2606    24812    consulta fk_consulta_medico    FK CONSTRAINT     z   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT fk_consulta_medico FOREIGN KEY (medico) REFERENCES public.medico(id);
 E   ALTER TABLE ONLY public.consulta DROP CONSTRAINT fk_consulta_medico;
       public       postgres    false    196    2750    201            �
           2606    24832    medico fk_medico_especialidade    FK CONSTRAINT     �   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT fk_medico_especialidade FOREIGN KEY (especialidade) REFERENCES public.especialidade(id);
 H   ALTER TABLE ONLY public.medico DROP CONSTRAINT fk_medico_especialidade;
       public       postgres    false    197    201    2742            �
           2606    24837 '   receituario fkhas5d0at82k2mk5cjn42aqb5d    FK CONSTRAINT     �   ALTER TABLE ONLY public.receituario
    ADD CONSTRAINT fkhas5d0at82k2mk5cjn42aqb5d FOREIGN KEY (consulta) REFERENCES public.consulta(id);
 Q   ALTER TABLE ONLY public.receituario DROP CONSTRAINT fkhas5d0at82k2mk5cjn42aqb5d;
       public       postgres    false    196    203    2740            �
           2606    24817 !   exame fklc0drqnefb574b13qd7qisjkg    FK CONSTRAINT     �   ALTER TABLE ONLY public.exame
    ADD CONSTRAINT fklc0drqnefb574b13qd7qisjkg FOREIGN KEY (consulta) REFERENCES public.consulta(id);
 K   ALTER TABLE ONLY public.exame DROP CONSTRAINT fklc0drqnefb574b13qd7qisjkg;
       public       postgres    false    198    196    2740            �
           2606    24862 &   permissoes fks5pf54lfqapwx7gw30i3q0gv5    FK CONSTRAINT     �   ALTER TABLE ONLY public.permissoes
    ADD CONSTRAINT fks5pf54lfqapwx7gw30i3q0gv5 FOREIGN KEY (usuario) REFERENCES public.usuario(nome_usuario);
 P   ALTER TABLE ONLY public.permissoes DROP CONSTRAINT fks5pf54lfqapwx7gw30i3q0gv5;
       public       postgres    false    212    2760    211            �
           2606    24857 &   permissoes fksvnmcccxhr3ivf0io79vhafkg    FK CONSTRAINT     �   ALTER TABLE ONLY public.permissoes
    ADD CONSTRAINT fksvnmcccxhr3ivf0io79vhafkg FOREIGN KEY (permissao) REFERENCES public.permissao(nome);
 P   ALTER TABLE ONLY public.permissoes DROP CONSTRAINT fksvnmcccxhr3ivf0io79vhafkg;
       public       postgres    false    2756    210    211            J      x������ � �      K      x�3�tN,J����O�L����� ;K      L      x������ � �      M      x�3�tO,JI�K̩J������ ;HU      N      x������ � �      O   S   x�3�4Գ0@&����)�e�9�F����F�F���9�
��)����f�����ɥ9�y���&�0�il�kdd�i����� 02>      P   L   x�3�4Գ0@&���EE�y)��F����F�F���9�
�ə�y%��f�����ɥ9�y���&�0����� �'�      X   W   x�st����	rt��tL����,.)JL�/J-VH�W(rSs�B�C�<�9C�K/,��G�t��t�q�t��L�+A����� 4"�      Y   2   x�+H,��O�,)���u���*@st����	rt������ ֮(      Q      x������ � �      Z   S   x�+H,��O�,)���420��54�50�, �'A�M�s3s���s9@�
� Y�Ģ�̼bg��F�&�f\1z\\\ �7     